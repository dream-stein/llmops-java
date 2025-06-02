package com.emcikem.llm.service.service.dataset;

import com.emcikem.llm.common.enums.DataBaseStatusEnum;
import com.emcikem.llm.common.enums.LlmOpsResultEnum;
import com.emcikem.llm.common.exception.LlmOpsException;
import com.emcikem.llm.common.util.GsonUtil;
import com.emcikem.llm.common.vo.dataset.process.DocumentProcessVO;
import com.emcikem.llm.dao.entity.LlmOpsDocumentDO;
import com.emcikem.llm.dao.entity.LlmOpsKeywordTableDO;
import com.emcikem.llm.dao.entity.LlmOpsProcessRuleDO;
import com.emcikem.llm.dao.entity.LlmOpsSegmentDO;
import com.emcikem.llm.dao.entity.LlmOpsUploadFileDO;
import com.emcikem.llm.service.provider.LLMOpsDatasetProvider;
import com.emcikem.llm.service.provider.LLMOpsKeyWordProvider;
import com.emcikem.llm.service.provider.LLMOpsProcessRuleProvider;
import com.emcikem.llm.service.provider.LlmOpsUploadFileProvider;
import com.emcikem.llm.service.util.FileUtil;
import com.emcikem.llm.service.util.JieBaUtil;
import com.emcikem.llm.service.util.TextCleanUtil;
import com.emcikem.llm.service.util.TokenUtil;
import com.google.common.collect.Maps;
import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.Metadata;
import dev.langchain4j.data.segment.TextSegment;
import jakarta.annotation.Resource;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.compress.utils.Lists;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Create with Emcikem on 2025/5/22
 *
 * @author Emcikem
 * @version 1.0.0
 */
@Service
public class LLMOpsDocumentTask {

    @Resource
    private LLMOpsDatasetProvider llmOpsDatasetProvider;

    @Resource
    private LlmOpsUploadFileProvider llmOpsUploadFileProvider;

    @Resource
    private LLMOpsDocumentLoaderService llmOpsDocumentLoaderService;

    @Resource
    private LLMOpsProcessRuleProvider llmOpsProcessRuleProvider;

    @Resource
    private LLMOpsKeyWordProvider llmOpsKeyWordProvider;

    @Resource
    private VectorDatabaseService vectorDatabaseService;

    /**
     * 根据传递的文档id列表构建文档，涵盖了加载、分割、索引构建、数据村粗等内容
     * @param documentIdList
     */
    public void buildDocumentsAsync(List<String> documentIdList) {
        // 1. 根据传递的文档id获取所有的文档
        List<LlmOpsDocumentDO> llmOpsDocumentList = llmOpsDatasetProvider.getDocumentListByIdList(documentIdList);

        // 2. 执行循环遍历所有文档完成对每个文档的构建
        for (LlmOpsDocumentDO documentDO : llmOpsDocumentList) {
            try {
                // 3. 更新当前状态为解析中，并记录开始处理的时间
                documentDO.setStatus(DataBaseStatusEnum.PARSING.getDesc());
                documentDO.setProcessingStartedAt(new Date());
                documentDO.setUpdatedAt(new Date());
                boolean result = llmOpsDatasetProvider.updateDocument(documentDO);

                // 4. 执行文档加载步骤，并更新文档的状态与时间
                Document lcDocument = parsing(documentDO);

                // 5. 执行文档分割步骤，并更新文档状态与时间，涵盖片段的信息
                List<TextSegment> lcSegmentList = splitting(documentDO, lcDocument);

                // 6. 执行文档索引构建，涵盖关键词提取、向量、并更新数据状态
                indexing(documentDO, lcSegmentList);

                // 7. 存储操作，涵盖文档状态更新，以及向量数据库的存储
                completed(documentDO, lcSegmentList);

            } catch (Exception ex) {
                documentDO.setStatus(DataBaseStatusEnum.ERROR.getDesc());
                documentDO.setError(ex.getMessage());
                documentDO.setStoppedAt(new Date());
                documentDO.setUpdatedAt(new Date());
                boolean result = llmOpsDatasetProvider.updateDocument(documentDO);
            }
        }
    }

    /**
     * 村粗文档片段到向量数据库，并完成状态更新
     * @param llmOpsDocumentDO
     * @param lcSegmentList
     */
    public void completed(LlmOpsDocumentDO llmOpsDocumentDO, List<TextSegment> lcSegmentList) {
        // 1. 循环遍历片段列表数据，将文档状态以及片段状态设置为True
        for (TextSegment lcSegment : lcSegmentList) {
            lcSegment.metadata().put("document_enabled", Boolean.TRUE.toString());
            lcSegment.metadata().put("segment_enabled", Boolean.TRUE.toString());
        }

        // 2. 调用向量数据库，每次存储10条数据，避免一次传递过多的数据
        for (int i = 0; i < lcSegmentList.size(); i += 10) {
            // 3. 提取需要存储的数据和ids
            List<TextSegment> textSegments = lcSegmentList.subList(i, Math.min(lcSegmentList.size(), i + 10));
            List<String> nodeIdxList = textSegments.stream().map(x->x.metadata().getString("node_id")).toList();

            // 4. TODO:调用向量数据库存储对应的数据
            vectorDatabaseService.addDocuments(textSegments, nodeIdxList);

            // 5. 更新关联片段的状态以及完成时间
            LlmOpsSegmentDO llmOpsSegmentDO = new LlmOpsSegmentDO();
            llmOpsSegmentDO.setStatus(DataBaseStatusEnum.COMPLETED.getDesc());
            llmOpsSegmentDO.setCompletedAt(new Date());
            llmOpsSegmentDO.setEnabled(true);
            llmOpsDatasetProvider.updateSegmentByNodeIds(llmOpsSegmentDO, nodeIdxList);
        }

        // 6. 更新文档的状态
        llmOpsDocumentDO.setStatus(DataBaseStatusEnum.COMPLETED.getDesc());
        llmOpsDocumentDO.setCompletedAt(new Date());
        llmOpsDocumentDO.setEnabled(false);
        boolean result = llmOpsDatasetProvider.updateDocument(llmOpsDocumentDO);

    }

    /**
     * 根据传递的信息构建索引，涵盖关键词提取，词表构建
     * @param documentDO
     * @param lcSegmentList
     */
    private void indexing(LlmOpsDocumentDO documentDO, List<TextSegment> lcSegmentList) {
        for (TextSegment lcSegment : lcSegmentList) {
            // 1. 提取每一个片段对应的关键词，关键词的数量最多不超过10个
            List<String> keyWords = JieBaUtil.extractKeyWords(lcSegment.text(), 10);

            // 2. 逐条更新文档片段的关键词 TODO: 批量更新
            LlmOpsSegmentDO llmOpsSegmentDO = new LlmOpsSegmentDO();
            llmOpsSegmentDO.setId(lcSegment.metadata().getString("segment_id"));
            llmOpsSegmentDO.setKeywords(GsonUtil.toJSONString(keyWords));
            llmOpsSegmentDO.setStatus(DataBaseStatusEnum.INDEXING.getDesc());
            llmOpsSegmentDO.setUpdatedAt(new Date());
            llmOpsSegmentDO.setIndexCompletedAt(new Date());
            boolean result = llmOpsDatasetProvider.updateSegment(llmOpsSegmentDO);

            // 3. 获取当前知识库的关键词表 
            LlmOpsKeywordTableDO keyWordTableDO = llmOpsKeyWordProvider.getKeyWordTableByDatasetId(llmOpsSegmentDO.getDatasetId());
            Map<String, List<String>> keywordTableMap = Maps.newHashMap();
            if (keyWordTableDO != null && StringUtils.isNoneEmpty(keyWordTableDO.getKeywordTable())) {
                keywordTableMap = GsonUtil.gsonToMaps(keyWordTableDO.getKeywordTable());
            }

            // 4. 循环将新的关键词添加到关键词表中
            for (String keyWord : keyWords) {
                if (!keywordTableMap.containsKey(keyWord)) {
                    keywordTableMap.put(keyWord, Lists.newArrayList());
                }
                keywordTableMap.get(keyWord).add(llmOpsSegmentDO.getId());
            }

            // 5. 更新关键词表
            if (keyWordTableDO == null) {
                LlmOpsKeywordTableDO llmOpsKeywordTableDO = getKeywordTableDO(keyWordTableDO, keywordTableMap, llmOpsSegmentDO.getDatasetId());
                boolean insertResult = llmOpsKeyWordProvider.insertKeywordTable(llmOpsKeywordTableDO);
            } else {
                boolean updateResult = llmOpsKeyWordProvider.updateKeyword(keyWordTableDO);
            }
        }

        // 7. 更新文档状态
        documentDO.setUpdatedAt(new Date());
        documentDO.setIndexCompletedAt(new Date());
        llmOpsDatasetProvider.updateDocument(documentDO);
    }

    private LlmOpsKeywordTableDO getKeywordTableDO(LlmOpsKeywordTableDO keyWordTableDO, Map<String, List<String>> keywordTableMap, String datasetId) {
        if (keyWordTableDO == null) {
            LlmOpsKeywordTableDO llmOpsKeywordTableDO = new LlmOpsKeywordTableDO();
            llmOpsKeywordTableDO.setId(UUID.randomUUID().toString());
            llmOpsKeywordTableDO.setDatasetId(datasetId);
            llmOpsKeywordTableDO.setKeywordTable(GsonUtil.toJSONString(keywordTableMap));
            llmOpsKeywordTableDO.setCreatedAt(new Date());
            llmOpsKeywordTableDO.setUpdatedAt(new Date());
            return llmOpsKeywordTableDO;
        }
        keyWordTableDO.setUpdatedAt(new Date());
        keyWordTableDO.setKeywordTable(GsonUtil.toJSONString(keywordTableMap));
        return keyWordTableDO;
    }

    /**
     * 根据传递的信息尽享文档分割，拆分成小块片段
     * @param documentDO
     * @param lcDocument
     * @return
     */
    private List<TextSegment> splitting(LlmOpsDocumentDO documentDO, Document lcDocument) {
        // 1. 根据process_rule获取文档分割器
        LlmOpsProcessRuleDO llmOpsProcessRuleDO = llmOpsProcessRuleProvider.getProcessRule(documentDO.getProcessRuleId());
        DocumentProcessVO documentProcessVO = GsonUtil.parseObject(llmOpsProcessRuleDO.getRule(), DocumentProcessVO.class);
        if (documentProcessVO == null) {
            throw new LlmOpsException(LlmOpsResultEnum.SYSTEM_ERROR);
        }

        // 2. 按照process_rule规则清除多余的字符串
        lcDocument = Document.from(llmOpsDocumentLoaderService.cleanTextByProcessRule(lcDocument.text(), documentProcessVO.getRule()));

        // 3. 分割文档列表为片段列表
        List<TextSegment> lcSegmentList = llmOpsDocumentLoaderService.documentProcess(lcDocument, documentProcessVO);

        // 4. 获取对应文档下的最大文档位置
        Integer position = llmOpsDatasetProvider.getLatestSegmentPosition(documentDO.getId());

        // 5. 循环处理片段数据并添加元数据，他是存储到数据库中
        List<LlmOpsSegmentDO> llmOpsSegmentList = buildLlmOpsSegmentList(position, documentDO, lcSegmentList);
        boolean result = llmOpsDatasetProvider.createSegmentList(llmOpsSegmentList);

        // 6. 更新文档的数据，涵盖状态，token数等内容
        documentDO.setTokenCount(llmOpsSegmentList.stream().map(LlmOpsSegmentDO::getTokenCount).reduce(0, Integer::sum));
        documentDO.setUpdatedAt(new Date());
        documentDO.setStatus(DataBaseStatusEnum.INDEXING.getDesc());
        documentDO.setSplittingCompletedAt(new Date());
        boolean updateResult = llmOpsDatasetProvider.updateDocument(documentDO);

        return lcSegmentList;
    }

    private List<LlmOpsSegmentDO> buildLlmOpsSegmentList(Integer position, LlmOpsDocumentDO documentDO, List<TextSegment> textSegmentList) {
        if (CollectionUtils.isEmpty(textSegmentList)) {
            return Lists.newArrayList();
        }
        List<LlmOpsSegmentDO> llmOpsSegmentList = Lists.newArrayList();
        for (int i = 0; i < textSegmentList.size(); i++) {
            TextSegment textSegment = textSegmentList.get(i);
            position++;
            LlmOpsSegmentDO llmOpsSegmentDO = new LlmOpsSegmentDO();
            llmOpsSegmentDO.setAccountId(documentDO.getAccountId());
            llmOpsSegmentDO.setDatasetId(documentDO.getDatasetId());
            llmOpsSegmentDO.setDocumentId(documentDO.getId());
            llmOpsSegmentDO.setNodeId(UUID.randomUUID().toString());
            llmOpsSegmentDO.setContent(textSegment.text());
            llmOpsSegmentDO.setCharacterCount(textSegment.text().length());
            llmOpsSegmentDO.setTokenCount(TokenUtil.calculateTokenContent(textSegment.text()));
            llmOpsSegmentDO.setHash(FileUtil.generateTextHash(textSegment.text()));
            llmOpsSegmentDO.setStatus(DataBaseStatusEnum.WAITING.getDesc());

            llmOpsSegmentDO.setId(UUID.randomUUID().toString());
            llmOpsSegmentDO.setPosition(position);
            llmOpsSegmentDO.setEnabled(true);
            llmOpsSegmentDO.setCreatedAt(new Date());
            llmOpsSegmentDO.setUpdatedAt(new Date());

            Map<String, Object> meta = Maps.newHashMap();
            meta.put("account_id", documentDO.getAccountId());
            meta.put("dataset_id", documentDO.getDatasetId());
            meta.put("document_id", documentDO.getId());
            meta.put("segment_id", llmOpsSegmentDO.getId());
            meta.put("node", llmOpsSegmentDO.getNodeId());
            meta.put("document_enabled", Boolean.FALSE);
            meta.put("segment_enabled", Boolean.FALSE);

            textSegment = TextSegment.textSegment(textSegment.text(), new Metadata(meta));
            textSegmentList.set(i, textSegment);
            llmOpsSegmentList.add(llmOpsSegmentDO);
        }
        return llmOpsSegmentList;
    }

    /**
     * 解析传递的文档为LangChain文档列表
     * @param documentDO
     * @return
     */
    private Document parsing(LlmOpsDocumentDO documentDO) {
        // 1. 获取upload_file并加载LangChain文档
        LlmOpsUploadFileDO llmOpsUploadFileDO = llmOpsUploadFileProvider.selectFileByFileId(documentDO.getUploadFileId());
        Document lcDocument = llmOpsDocumentLoaderService.load(llmOpsUploadFileDO);

        // 2. 处理LangChain文档，并删除多余的空白字符串
        lcDocument = Document.from(cleanExtraText(lcDocument.text()));

        // 3. 更新文档状态并记录时间
        documentDO.setStatus(DataBaseStatusEnum.SPLITTING.getDesc());
        documentDO.setParsingCompletedAt(new Date());
        documentDO.setUpdatedAt(new Date());
        documentDO.setCharacterCount(lcDocument.text().length());
        boolean result = llmOpsDatasetProvider.updateDocument(documentDO);

        return lcDocument;
    }

    /**
     * 清除过滤传递的多余空白字符串
     * @param text
     * @return
     */
    public static String cleanExtraText(String text) {
        // 处理 <\| 替换为 <
        text = TextCleanUtil.replace(text, "<\\\\\\|", "<");
        // 处理 \|> 替换为 >
        text = TextCleanUtil.replace(text, "\\\\\\|>", ">");
        // 删除控制字符和特殊Unicode字符
        text = TextCleanUtil.replace(text, "[\u0000-\u0008\u000B-\u000C\u000E-\u001F\u007F\uFEFF\uFFFE]", "");
        return text;
    }

    public static void main(String[] args) {
        testCase("嵌套符号", "<\\|<\\|A\\|>\\|>", "<<A>>");
        testCase("非对称符号", "测试<\\|不完整\\|", "测试<不完整");
        testCase("转义混淆", "\\<\\|转义\\|>\\\\>", "\\<转义>\\>");
        testCase("Unicode变体", "测试<\\|\u4E2D\u6587\\|>", "测试<中文>");
        testCase("控制字符簇", "A\u0001\u0002\u0003B", "AB");
        testCase("零宽字符簇", "\uFFFE文本\uFFFE中间\uFFFE", "文本中间");
        testCase("BOM+控制符", "\uFEFF\u0000数据\u0007", "数据");
        testCase("符号在首尾", "<\\|开头\\|>文本<\\|结尾\\|>", "<开头>文本<结尾>");
        testCase("重复符号", "<\\|<\\|<\\|A\\|>\\|>\\|>", "<<<A>>>");
        testCase("空符号对", "<\\|\\|>", "<>");
        testCase("特殊Unicode", "\uD83D\uDE00<\\|笑脸\\|>", "\uD83D\uDE00<笑脸>"); // 保留表情符号
        testCase("HTML标签干扰", "<div><\\|内容\\|></div>", "<div><内容></div>");
        testCase("反向符号", "\\|><\\|", "><");
        testCase("超长文本",
                "<\\|超长文本\\|>".repeat(1000),
                "<超长文本>".repeat(1000));
        testCase("正则元字符", "测试$^.*+?()[]{}<\\|符号\\|>", "测试$^.*+?()[]{}<符号>");
    }

    private static void testCase(String name, String input, String expected) {
        String result = cleanExtraText(input);
        String status = result.equals(expected) ? "✅ 通过" : "❌ 失败";
        System.out.printf("%-15s | 输入长度: %d | 输出长度: %d | 状态: %s%n",
                name, input.length(), result.length(), status);
        if (!result.equals(expected)) {
            System.out.printf("       ❗ 输入: [%s]%n", input);
            System.out.printf("       ❗ 输出: [%s]%n", result);
            System.out.printf("       ❗ 预期: [%s]%n", expected);
        }
    }
}

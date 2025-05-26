package com.emcikem.llm.service.service.dataset;

import com.emcikem.llm.common.enums.PreProcessRuleEnum;
import com.emcikem.llm.common.vo.dataset.process.DocumentPreProcessRule;
import com.emcikem.llm.common.vo.dataset.process.DocumentProcessRule;
import com.emcikem.llm.common.vo.dataset.process.DocumentProcessVO;
import com.emcikem.llm.dao.entity.LlmOpsDocumentDO;
import com.emcikem.llm.dao.entity.LlmOpsSegmentDO;
import com.emcikem.llm.dao.entity.LlmOpsUploadFileDO;
import com.emcikem.llm.service.constant.LLMOpsConstant;
import com.emcikem.llm.service.provider.LLMOpsDatasetProvider;
import com.emcikem.llm.service.provider.LLMOpsSegmentProvider;
import com.emcikem.llm.service.provider.LlmOpsUploadFileProvider;
import com.emcikem.llm.service.util.AccountUtil;
import com.emcikem.llm.service.util.TextCleanUtil;
import com.google.common.collect.Lists;
import com.qcloud.cos.COSClient;
import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.DocumentSplitter;
import dev.langchain4j.data.document.loader.tencent.cos.TencentCosDocumentLoader;
import dev.langchain4j.data.document.parser.apache.tika.ApacheTikaDocumentParser;
import dev.langchain4j.data.document.splitter.DocumentByRegexSplitter;
import dev.langchain4j.data.document.splitter.DocumentBySentenceSplitter;
import dev.langchain4j.data.embedding.Embedding;
import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.store.embedding.inmemory.InMemoryEmbeddingStore;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * Create with Emcikem on 2025/4/13
 *
 * @author Emcikem
 * @version 1.0.0
 */
@Service
public class LLMOpsDocumentLoaderService {

    @Resource
    private COSClient cosClient;

    private final InMemoryEmbeddingStore<Embedding> inMemoryEmbeddingStore = new InMemoryEmbeddingStore<>();

    @Resource
    private EmbeddingModel embeddingModel;

    @Resource
    private LLMOpsSegmentProvider llmOpsSegmentProvider;

    @Resource
    private LlmOpsUploadFileProvider llmOpsUploadFileProvider;

    @Resource
    private LLMOpsDatasetProvider llmOpsDatasetProvider;

    public void loadDocument(String fileId, String datasetId) {
        LlmOpsUploadFileDO llmOpsUploadFileDO = llmOpsUploadFileProvider.selectFileByFileId(fileId);
        if (llmOpsUploadFileDO == null) {
            return;
        }
        String fileName = llmOpsUploadFileDO.getName();

        // 1.解析器解析文档
        Document document = loadDocument(fileName);

        // 2.分词器文档分词
        List<TextSegment> textSegmentList = documentProcess(document, buildDocumentProcessVO());

        // 3.文本向量化
        List<Embedding> embeddingList = textSegmentList.stream()
                .map(textSegment -> embeddingModel.embed(textSegment).content())
                .toList();

        // 4.创建document
        LlmOpsDocumentDO llmOpsDocumentDO = buildLLMOpsDocument(fileName, datasetId, llmOpsUploadFileDO.getId());
        boolean documentResult = llmOpsDatasetProvider.createDocument(llmOpsDocumentDO);

        // 5.创建向量数据库
        List<String> embeddingIdList = inMemoryEmbeddingStore.addAll(embeddingList);

        // 6.创建segment
        List<LlmOpsSegmentDO> llmOpsSegmentList = Lists.newArrayList();
        for (int i = 0; i < embeddingIdList.size(); i++) {
            String embeddingId = embeddingIdList.get(i);
            String text = textSegmentList.get(i).text();
            LlmOpsSegmentDO llmOpsSegmentDO = buildLlmOpsSegmentDO(text, i, datasetId, embeddingId, llmOpsDocumentDO.getId());

            llmOpsSegmentList.add(llmOpsSegmentDO);
        }
        boolean result = llmOpsSegmentProvider.batchInsertSegmentList(llmOpsSegmentList);

        // 4.检索增强

    }

    private LlmOpsDocumentDO buildLLMOpsDocument(String fileName, String datasetId, String fileId) {
        LlmOpsDocumentDO llmOpsDocumentDO = new LlmOpsDocumentDO();
        llmOpsDocumentDO.setName(fileName);
        llmOpsDocumentDO.setId(UUID.randomUUID().toString());
        llmOpsDocumentDO.setAccountId(AccountUtil.getAccountId());
        llmOpsDocumentDO.setUpdatedAt(new Date());
        llmOpsDocumentDO.setCreatedAt(new Date());
//        llmOpsDocumentDO.setEnabled();
//        llmOpsDocumentDO.setBatch();
//        llmOpsDocumentDO.setPosition();
//        llmOpsDocumentDO.setCharacterCount();
//        llmOpsDocumentDO.setCompletedAt();
        llmOpsDocumentDO.setDatasetId(datasetId);
        llmOpsDocumentDO.setUploadFileId(fileId);
//        llmOpsDocumentDO.setStoppedAt();
//        llmOpsDocumentDO.setStatus();
//        llmOpsDocumentDO.setSplittingCompletedAt();
//        llmOpsDocumentDO.setParsingCompletedAt();
//        llmOpsDocumentDO.setIndexCompletedAt();
        llmOpsDocumentDO.setDisabledAt(new Date());
        llmOpsDocumentDO.setError("");
//        llmOpsDocumentDO.setTokenCount();
//        llmOpsDocumentDO.setProcessingStartedAt();
        return llmOpsDocumentDO;
    }

    private Document loadDocument(String fileName) {
        TencentCosDocumentLoader documentLoader = new TencentCosDocumentLoader(cosClient);
        return documentLoader.loadDocument(LLMOpsConstant.BUCKET_NAME, fileName, new ApacheTikaDocumentParser());
    }

    private LlmOpsSegmentDO buildLlmOpsSegmentDO(String text, Integer position, String datasetId, String embeddingId, String documentId) {
        LlmOpsSegmentDO llmOpsSegmentDO = new LlmOpsSegmentDO();
        llmOpsSegmentDO.setContent(text);
        llmOpsSegmentDO.setId(UUID.randomUUID().toString());
        llmOpsSegmentDO.setNodeId(embeddingId);
        llmOpsSegmentDO.setPosition(position);
        llmOpsSegmentDO.setUpdatedAt(new Date());
        llmOpsSegmentDO.setCreatedAt(new Date());
        llmOpsSegmentDO.setCharacterCount(text.length());
        llmOpsSegmentDO.setDatasetId(datasetId);
        llmOpsSegmentDO.setEnabled(true);
        llmOpsSegmentDO.setDocumentId(documentId);

        return llmOpsSegmentDO;
    }

    private DocumentProcessVO buildDocumentProcessVO() {
        DocumentProcessVO documentProcessVO = new DocumentProcessVO();
        documentProcessVO.setProcessType("custom");
        DocumentProcessRule documentProcessRule = new DocumentProcessRule();
        documentProcessRule.setChunk_overlap(50);
        documentProcessRule.setChunk_size(500);
        documentProcessRule.setRegex("\\n\\d+\\.");
        documentProcessRule.setSeparators("\n");
        documentProcessVO.setRule(documentProcessRule);
        return documentProcessVO;
    }

    /**
     * 根据传递的处理规则清除多余的字符串
     * @param text
     * @param documentProcessRule
     * @return
     */
    public String cleanTextByProcessRule(String text, DocumentProcessRule documentProcessRule) {
        // 1. 循环遍历所有预处理规则
        for (DocumentPreProcessRule preProcessRule : documentProcessRule.getPre_process_rules()) {
            // 2. 删除多余的空格
            if (PreProcessRuleEnum.REMOVE_EXTRA_SPACE.getDesc().equals(preProcessRule.getId()) && BooleanUtils.isFalse(preProcessRule.getEnabled())) {
                text = TextCleanUtil.replace(text, "\\n{3,}", "\n\n");
                text = TextCleanUtil.replace(text, "[\\t\\f\\r\\x20\\u00a0\\u1680\\u180e\\u2000-\\u200a\\u202f\\u205f\\u3000]{2,}", " ");
            }
            // 3. 删除多余的URL链接及邮箱
            if (PreProcessRuleEnum.REMOVE_URL_AND_EMAIL.getDesc().equals(preProcessRule.getId()) && BooleanUtils.isFalse(preProcessRule.getEnabled())) {
                text = TextCleanUtil.replace(text, "[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+", "");
                text = TextCleanUtil.replace(text, "https?://[^\\s]+", "");
            }
        }
        return text;
    }

    /**
     * 分词器
     * 1：automatic：自动分段与清洗
     * 2：custom：自定义分段规则
     * 分词器有以下
     * DocumentByParagraphSplitter 删除大段空白内容 处理连续换行符（如段落符）
     * DocumentByLineSplitter 删除单个换行符周围的空白，替换一个换行
     * DocumentBySentenceSplitter 按句子分割，
     * DocumentByWordSplitter 删除连续的空白字符
     * DocumentByCharacterSplitter 无符号分割，严格根据字数分割
     * DocumentByRegexSplitter 正则表达式分割，根据自定义正则分割
     */
    public List<TextSegment> documentProcess(Document document, DocumentProcessVO documentProcessVO) {
        String processType = documentProcessVO.getProcessType();
        if (Objects.equals(processType, "automatic")) {
            DocumentBySentenceSplitter splitter = new DocumentBySentenceSplitter(500, 50);
            return splitter.split(document);
        } else if (Objects.equals(processType, "custom")) {
            DocumentProcessRule rule = documentProcessVO.getRule();
            DocumentByRegexSplitter splitter = new DocumentByRegexSplitter(
                    rule.getRegex(),
                    rule.getSeparators(),
                    rule.getChunk_size(),
                    rule.getChunk_overlap()
            );
            return splitter.split(document);
        } else {
            return Lists.newArrayList();
        }
    }

    public Document load(LlmOpsUploadFileDO llmOpsUploadFileDO) {
        String fileName = llmOpsUploadFileDO.getName();
        TencentCosDocumentLoader documentLoader = new TencentCosDocumentLoader(cosClient);
        return documentLoader.loadDocument(LLMOpsConstant.BUCKET_NAME, fileName, new ApacheTikaDocumentParser());
    }

    /**
     * 文件提取提，用于将远程文件、upload_file记录加载成LangChain对应的文档或字符串
     * @param uploadFileDO
     * @param returnText
     * @param isUnstructured
     * @return
     */
    public Pair<List<Document>, String> load(LlmOpsUploadFileDO uploadFileDO, boolean returnText, boolean isUnstructured) {

        return null;
    }

    /**
     * 从传入的URL中去加载数据，返回LangChain文档列表或者字符串
     * @param url
     * @param returnText
     * @param isUnstructured
     * @return
     */
    public Pair<List<Document>, String> loadFromUrl(String url, boolean returnText, boolean isUnstructured) {
        // 1. 下载远程URL的文件到本地

        // 2. 将文件下载到本地的临时文件夹
        return null;
    }

    /**
     * 从本地文件中加载数据，返回LangChain文档列表或者字符串
     * @param filePath
     * @param returnText
     * @param isUnstructured
     * @return
     */
    public Pair<List<Document>, String> loadFromFile(String filePath, boolean returnText, boolean isUnstructured) {
        // 1. 获取文件的扩展名

        // 2. 根据不同的文件扩展名去加载不同的加载器

        // 3. 返回加载的文档列表或者文本
        return null;
    }
}

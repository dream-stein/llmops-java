package com.emcikem.llm.service.service.dataset;

import com.emcikem.llm.common.vo.dataset.process.DocumentProcessRule;
import com.emcikem.llm.common.vo.dataset.process.DocumentProcessVO;
import com.emcikem.llm.dao.entity.LlmOpsDocumentDO;
import com.emcikem.llm.dao.entity.LlmOpsSegmentDO;
import com.emcikem.llm.service.constant.LLMOpsConstant;
import com.emcikem.llm.service.provider.LLMOpsDocumentProvider;
import com.emcikem.llm.service.provider.LLMOpsSegmentProvider;
import com.google.common.collect.Lists;
import com.qcloud.cos.COSClient;
import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.loader.tencent.cos.TencentCosDocumentLoader;
import dev.langchain4j.data.document.parser.TextDocumentParser;
import dev.langchain4j.data.document.parser.apache.tika.ApacheTikaDocumentParser;
import dev.langchain4j.data.document.splitter.DocumentByCharacterSplitter;
import dev.langchain4j.data.document.splitter.DocumentByRegexSplitter;
import dev.langchain4j.data.document.splitter.DocumentBySentenceSplitter;
import dev.langchain4j.data.embedding.Embedding;
import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.store.embedding.inmemory.InMemoryEmbeddingStore;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Create with Emcikem on 2025/4/13
 *
 * @author Emcikem
 * @version 1.0.0
 */
@Service
public class LLMOpsDatabaseFileService {

    @Resource
    private COSClient cosClient;

    private final InMemoryEmbeddingStore<Embedding> inMemoryEmbeddingStore = new InMemoryEmbeddingStore<>();

    @Resource
    private EmbeddingModel embeddingModel;

    @Resource
    private LLMOpsSegmentProvider llmOpsSegmentProvider;

    @Resource
    private LLMOpsDocumentProvider llmOpsDocumentProvider;

    public void loadDocument(String fileName, String datasetId) {
        // 1.解析器
        TencentCosDocumentLoader documentLoader = new TencentCosDocumentLoader(cosClient);
        Document document = documentLoader.loadDocument(LLMOpsConstant.BUCKET_NAME, fileName, new ApacheTikaDocumentParser());

        // 2.分词器
        DocumentProcessVO documentProcessVO = new DocumentProcessVO();
        documentProcessVO.setProcessType("custom");
        DocumentProcessRule documentProcessRule = new DocumentProcessRule();
        documentProcessRule.setChunk_overlap(50);
        documentProcessRule.setChunk_size(500);
        documentProcessRule.setRegex("\\n\\d+\\.");
        documentProcessRule.setSeparators("\n");
        documentProcessVO.setRule(documentProcessRule);
        List<TextSegment> textSegmentList = documentProcess(document, documentProcessVO);

        // 3.文本向量化
        List<Embedding> embeddingList = textSegmentList.stream()
                .map(textSegment -> embeddingModel.embed(textSegment).content())
                .toList();

        // 4.创建document
        LlmOpsDocumentDO llmOpsDocumentDO = new LlmOpsDocumentDO();
        llmOpsDocumentProvider.insert(llmOpsDocumentDO);

        // 5.创建向量数据库
        List<String> embeddingIdList = inMemoryEmbeddingStore.addAll(embeddingList);

        // 6.创建segment
        List<LlmOpsSegmentDO> llmOpsSegmentList = Lists.newArrayList();
        for (int i = 0; i < embeddingIdList.size(); i++) {
            String embeddingId = embeddingIdList.get(i);
            String text = textSegmentList.get(i).text();

            LlmOpsSegmentDO llmOpsSegmentDO = new LlmOpsSegmentDO();
            llmOpsSegmentDO.setContent(text);
            llmOpsSegmentDO.setId(UUID.randomUUID().toString());
            llmOpsSegmentDO.setNodeId(embeddingId);
            llmOpsSegmentDO.setPosition(i);
            llmOpsSegmentDO.setUpdatedAt(new Date());
            llmOpsSegmentDO.setCreatedAt(new Date());
            llmOpsSegmentDO.setCharacterCount(text.length());
            llmOpsSegmentDO.setDatasetId(datasetId);
            llmOpsSegmentDO.setEnabled(true);
            llmOpsSegmentDO.setDocumentId(llmOpsDocumentDO.getId());

            llmOpsSegmentList.add(llmOpsSegmentDO);
        }
        boolean result = llmOpsSegmentProvider.batchInsertSegmentList(llmOpsSegmentList);

        // 4.检索增强
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
    private List<TextSegment> documentProcess(Document document, DocumentProcessVO documentProcessVO) {
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
}

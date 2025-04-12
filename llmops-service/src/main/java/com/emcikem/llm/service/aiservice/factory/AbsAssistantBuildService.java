package com.emcikem.llm.service.aiservice.factory;

import com.emcikem.llm.common.enums.ChatModelEnum;
import com.emcikem.llm.service.aiservice.Assistant;
import com.emcikem.llm.service.aiservice.tools.AssistantTools;
import com.emcikem.llm.service.aiservice.PersistentChatMemoryStore;
import com.google.common.collect.Maps;
import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.DocumentParser;
import dev.langchain4j.data.document.DocumentSplitter;
import dev.langchain4j.data.document.loader.FileSystemDocumentLoader;
import dev.langchain4j.data.document.parser.TextDocumentParser;
import dev.langchain4j.data.document.splitter.DocumentSplitters;
import dev.langchain4j.data.embedding.Embedding;
import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.memory.chat.ChatMemoryProvider;
import dev.langchain4j.memory.chat.TokenWindowChatMemory;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.chat.StreamingChatLanguageModel;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.model.embedding.onnx.bgesmallenv15q.BgeSmallEnV15QuantizedEmbeddingModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.model.openai.OpenAiStreamingChatModel;
import dev.langchain4j.model.openai.OpenAiTokenizer;
import dev.langchain4j.rag.content.retriever.ContentRetriever;
import dev.langchain4j.rag.content.retriever.EmbeddingStoreContentRetriever;
import dev.langchain4j.service.AiServices;
import dev.langchain4j.store.embedding.EmbeddingSearchRequest;
import dev.langchain4j.store.embedding.EmbeddingSearchResult;
import dev.langchain4j.store.embedding.EmbeddingStore;
import dev.langchain4j.store.embedding.inmemory.InMemoryEmbeddingStore;

import jakarta.annotation.Resource;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.List;
import java.util.Map;


/**
 * Create with Emcikem on 2025/1/20
 *
 * @author Emcikem
 * @version 1.0.0
 */
public abstract class AbsAssistantBuildService implements AssistantBuildService {

    @Resource
    private PersistentChatMemoryStore persistentChatMemoryStore;

    @Resource
    private AssistantTools assistantTools;

    @Resource
    private OpenAiTokenizer openAiTokenizer;

    @Override
    public String getModelName() {
        return getChatModelEnum().getModelName();
    }

    @Override
    public Assistant getAssistant() {
        ChatMemoryProvider chatMemoryProvider = memoryId -> TokenWindowChatMemory.builder()
                .id(memoryId)
                .maxTokens(1000, openAiTokenizer)
                .chatMemoryStore(persistentChatMemoryStore)
                .build();

        ChatLanguageModel model = getLanguageModel();
        StreamingChatLanguageModel streamModel = getStreamingLanguageModel();

        return AiServices.builder(Assistant.class)
                .chatLanguageModel(model)
                .streamingChatLanguageModel(streamModel)
                .chatMemoryProvider(chatMemoryProvider)
                .tools(assistantTools)
//                .contentRetriever(getContentRetriever())
                .build();
    }

    protected ChatLanguageModel getLanguageModel() {
        return OpenAiChatModel.builder()
                .baseUrl(getChatModelEnum().getBaseUrl())
                .apiKey(getApiKey())
                .modelName(getChatModelEnum().getModelName())
                .build();
    }

    protected StreamingChatLanguageModel getStreamingLanguageModel() {
        return OpenAiStreamingChatModel.builder()
                .baseUrl(getChatModelEnum().getBaseUrl())
                .apiKey(getApiKey())
                .modelName(getChatModelEnum().getModelName())
                .build();
    }

    protected ContentRetriever getContentRetriever() {
        DocumentParser documentParser = new TextDocumentParser();
        Document document;
        try {
            org.springframework.core.io.Resource resource = new ClassPathResource("doc/repomix-output.txt");
            document = FileSystemDocumentLoader.loadDocument(resource.getFile().getPath(), documentParser);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load document: " + e.getMessage(), e);
        }


        DocumentSplitter splitter = DocumentSplitters.recursive(300, 0);
        List<TextSegment> segments = splitter.split(document);


        EmbeddingModel embeddingModel = new BgeSmallEnV15QuantizedEmbeddingModel();
        List<Embedding> embeddings = embeddingModel.embedAll(segments).content();


        EmbeddingStore<TextSegment> embeddingStore = new InMemoryEmbeddingStore<>();
        embeddingStore.addAll(embeddings, segments);


        return EmbeddingStoreContentRetriever.builder()
                .embeddingStore(embeddingStore)
                .embeddingModel(embeddingModel)
                .maxResults(2) // on each interaction we will retrieve the 2 most relevant segments
                .minScore(0.5) // we want to retrieve segments at least somewhat similar to user query
                .build();
    }

    abstract String getApiKey();

    abstract ChatModelEnum getChatModelEnum();


    public static void main(String[] args) {
        Map<String, TextSegment> textSegmentMap = Maps.newHashMap();

        // embedding
        InMemoryEmbeddingStore<Embedding> embeddingStore = new InMemoryEmbeddingStore<>();
        EmbeddingModel embeddingModel = new BgeSmallEnV15QuantizedEmbeddingModel();

        TextSegment segment1 = TextSegment.from("预定航班：通过我们的网站或者移动应用程序");
        Embedding embedding1 = embeddingModel.embed(segment1).content();
        String segmentId1 = embeddingStore.add(embedding1);
        textSegmentMap.put(segmentId1, segment1);

        TextSegment segment2 = TextSegment.from("取消航班：最晚在航班起飞前48小时取消; 取消费用：经济舱75美元");
        Embedding embedding2 = embeddingModel.embed(segment2).content();
        String segmentId2 = embeddingStore.add(embedding2);
        textSegmentMap.put(segmentId2, segment2);

        // retriever
        Embedding queryEmbedding = embeddingModel.embed("取消费用要多少钱").content();
        EmbeddingSearchRequest request = EmbeddingSearchRequest.builder()
                .queryEmbedding(queryEmbedding)
                .maxResults(20)
                .build();

        EmbeddingSearchResult<Embedding> searchResult = embeddingStore.search(request);
        searchResult.matches().forEach(embeddingMatch -> {
            System.out.println(embeddingMatch.score());
            System.out.println(textSegmentMap.get(embeddingMatch.embeddingId()));
        });
    }
}

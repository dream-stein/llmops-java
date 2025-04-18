package com.emcikem.llm.service.service;

import com.emcikem.llm.service.util.Assistant;
import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.loader.FileSystemDocumentLoader;
import dev.langchain4j.data.segment.TextSegment;

import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.rag.content.retriever.ContentRetriever;
import dev.langchain4j.rag.content.retriever.EmbeddingStoreContentRetriever;
import dev.langchain4j.service.AiServices;
import dev.langchain4j.store.embedding.EmbeddingStoreIngestor;
import dev.langchain4j.store.embedding.inmemory.InMemoryEmbeddingStore;
import lombok.extern.slf4j.Slf4j;

import java.nio.file.FileSystems;
import java.nio.file.PathMatcher;
import java.util.List;

import static com.emcikem.llm.service.util.Utils.startConversationWith;

/**
 * @author zhuleiye02
 * @date 2025/3/9
 */
@Slf4j
public class RAGSample {

    static PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher("glob:*.txt");

    static List<Document> documents = FileSystemDocumentLoader.loadDocuments("/Users/zhuleiye02/Git/llmops/llmops-web/src/main/resources/doc",pathMatcher);

    private static ContentRetriever createContentRetriever(List<Document> documents) {

        // Here, we create an empty in-memory store for our documents and their embeddings.
        InMemoryEmbeddingStore<TextSegment> embeddingStore = new InMemoryEmbeddingStore<>();

        // Here, we are ingesting our documents into the store.
        // Under the hood, a lot of "magic" is happening, but we can ignore it for now.
        EmbeddingStoreIngestor.ingest(documents, embeddingStore);
        System.out.println("ingest done");
        // Lastly, let's create a content retriever from an embedding store.
        return EmbeddingStoreContentRetriever.from(embeddingStore);
    }


    static ChatLanguageModel chatModel = OpenAiChatModel.builder()
            .apiKey(System.getenv("OPENAI_API_KEY"))
            .baseUrl("https://api.deepseek.com")
            .modelName("deepseek-chat")
            .build();

    static Assistant assistant = AiServices.builder(Assistant.class)
            .chatLanguageModel(chatModel)
            .chatMemory(MessageWindowChatMemory.withMaxMessages(10))
            .contentRetriever(createContentRetriever(documents))
            .build();

    public static void main(String[] args) {
        System.out.println("start");
        startConversationWith(assistant);

    }
}

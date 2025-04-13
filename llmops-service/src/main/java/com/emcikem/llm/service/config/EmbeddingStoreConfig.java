package com.emcikem.llm.service.config;

import dev.langchain4j.data.embedding.Embedding;
import dev.langchain4j.store.embedding.inmemory.InMemoryEmbeddingStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Create with Emcikem on 2025/4/13
 *
 * @author Emcikem
 * @version 1.0.0
 */
@Configuration
public class EmbeddingStoreConfig {

    @Bean
    public InMemoryEmbeddingStore<Embedding> getEmbeddingStore() {
        return new InMemoryEmbeddingStore<>();
    }
}

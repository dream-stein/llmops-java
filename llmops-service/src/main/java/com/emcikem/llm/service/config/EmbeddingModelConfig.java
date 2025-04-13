package com.emcikem.llm.service.config;

import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.model.embedding.onnx.bgesmallenv15q.BgeSmallEnV15QuantizedEmbeddingModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Create with Emcikem on 2025/4/13
 *
 * @author Emcikem
 * @version 1.0.0
 */
@Configuration
public class EmbeddingModelConfig {

    @Bean
    public EmbeddingModel getEmbeddingModel() {
        return new BgeSmallEnV15QuantizedEmbeddingModel();
    }
}

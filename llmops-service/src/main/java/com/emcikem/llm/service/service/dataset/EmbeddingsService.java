package com.emcikem.llm.service.service.dataset;

import com.emcikem.llm.service.gateway.RedisGateway;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.model.embedding.onnx.bgesmallenv15q.BgeSmallEnV15QuantizedEmbeddingModel;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * Create with Emcikem on 2025/5/20
 *
 * @author Emcikem
 * @version 1.0.0
 */
@Service
public class EmbeddingsService {

    private EmbeddingModel embeddingModel = new BgeSmallEnV15QuantizedEmbeddingModel();

    @Resource
    private RedisGateway redisGateway;

    /**
     * 计算传入文本的token数
     * @param query
     * @return
     */
    public Integer calculateTokenCount(String query) {
        return 0;
    }
}

package com.emcikem.llm.service.service.dataset;

import dev.langchain4j.data.embedding.Embedding;
import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.store.embedding.inmemory.InMemoryEmbeddingStore;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Create with Emcikem on 2025/6/2
 *
 * @author Emcikem
 * @version 1.0.0
 */
@Service
@Slf4j
public class VectorDatabaseService {

    private InMemoryEmbeddingStore<Embedding> embeddingStore;

    public boolean addDocuments(List<TextSegment> textSegmentList, List<String> nodeIdList) {

    }
}

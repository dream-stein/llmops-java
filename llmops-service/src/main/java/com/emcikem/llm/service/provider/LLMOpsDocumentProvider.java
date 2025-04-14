package com.emcikem.llm.service.provider;

import com.emcikem.llm.dao.entity.LlmOpsDocumentDO;
import com.emcikem.llm.dao.mapper.LlmOpsDocumentDOMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * Create with Emcikem on 2025/4/14
 *
 * @author Emcikem
 * @version 1.0.0
 */
@Service
public class LLMOpsDocumentProvider {

    @Resource
    private LlmOpsDocumentDOMapper llmOpsDocumentDOMapper;

    public boolean insert(LlmOpsDocumentDO llmOpsDocumentDO) {
        return llmOpsDocumentDOMapper.insert(llmOpsDocumentDO) == 1;
    }
}

package com.emcikem.llm.service.provider;

import com.emcikem.llm.dao.entity.LlmOpsProcessRuleDO;
import com.emcikem.llm.dao.mapper.LlmOpsProcessRuleDOMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * Create with Emcikem on 2025/5/21
 *
 * @author Emcikem
 * @version 1.0.0
 */
@Service
public class LLMOpsProcessRuleProvider {

    @Resource
    private LlmOpsProcessRuleDOMapper llmOpsProcessRuleDOMapper;

    public boolean insert(LlmOpsProcessRuleDO llmOpsProcessRuleDO) {
        return llmOpsProcessRuleDOMapper.insertSelective(llmOpsProcessRuleDO) == 1;
    }
}

package com.emcikem.llm.service.provider;

import com.emcikem.llm.dao.example.LlmOpsAppDatasetJoinDOExample;
import com.emcikem.llm.dao.mapper.LlmOpsAppDatasetJoinDOMapper;
import org.springframework.stereotype.Service;

/**
 * Create with Emcikem on 2025/5/17
 *
 * @author Emcikem
 * @version 1.0.0
 */
@Service
public class LLMOpsAppDatasetJoinProvider {

    private LlmOpsAppDatasetJoinDOMapper llmOpsAppDatasetJoinDOMapper;

    public Long countAppDatasetJoin(String datasetId) {
        LlmOpsAppDatasetJoinDOExample example = new LlmOpsAppDatasetJoinDOExample();
        example.createCriteria().andDatasetIdEqualTo(datasetId);
        return llmOpsAppDatasetJoinDOMapper.countByExample(example);
    }
}

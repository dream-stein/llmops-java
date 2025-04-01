package com.emcikem.llm.service.provider;

import com.emcikem.llm.dao.entity.LlmOpsDatasetQueryDO;
import com.emcikem.llm.dao.example.LlmOpsDatasetQueryDOExample;
import com.emcikem.llm.dao.mapper.LlmOpsDatasetQueryDOMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Create with Emcikem on 2025/4/2
 *
 * @author Emcikem
 * @version 1.0.0
 */
@Service
public class LLMOpsDatasetQueryProvider {

    @Resource
    private LlmOpsDatasetQueryDOMapper llmOpsDatasetQueryDOMapper;

    public List<LlmOpsDatasetQueryDO> getDatasetQueries(String datasetId) {
        LlmOpsDatasetQueryDOExample example = new LlmOpsDatasetQueryDOExample();
        example.setOrderByClause("id desc");
        LlmOpsDatasetQueryDOExample.Criteria criteria = example.createCriteria();
        criteria.andDatasetIdEqualTo(datasetId);
        return llmOpsDatasetQueryDOMapper.selectByExample(example);
    }
}

package com.emcikem.llm.service.provider;

import com.emcikem.llm.dao.entity.LlmOpsApiKeyDO;
import com.emcikem.llm.dao.entity.LlmOpsDatasetDO;
import com.emcikem.llm.dao.example.LlmOpsApiKeyDOExample;
import com.emcikem.llm.dao.example.LlmOpsDatasetDOExample;
import com.emcikem.llm.dao.mapper.LlmOpsDatasetDOMapper;
import jakarta.annotation.Resource;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Create with Emcikem on 2025/3/30
 *
 * @author Emcikem
 * @version 1.0.0
 */
@Service
public class LLMOpsDatasetProvider {

    @Resource
    private LlmOpsDatasetDOMapper llmOpsDatasetDOMapper;

    public LlmOpsDatasetDO getDataset(String datasetId, String accountId) {
        LlmOpsDatasetDOExample example = new LlmOpsDatasetDOExample();
        LlmOpsDatasetDOExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(datasetId);
        criteria.andAccountIdEqualTo(accountId);
        List<LlmOpsDatasetDO> llmOpsDatasetList = llmOpsDatasetDOMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(llmOpsDatasetList)) {
            return null;
        }
        return llmOpsDatasetList.get(0);
    }

    public Long countDatasetList(String accountId, String searchWord) {
        LlmOpsDatasetDOExample example = new LlmOpsDatasetDOExample();
        LlmOpsDatasetDOExample.Criteria criteria = example.createCriteria();
        criteria.andAccountIdEqualTo(accountId);
        if (StringUtils.isNoneBlank(searchWord)) {
            criteria.andNameLike("%" + searchWord + "%");
        }
        return llmOpsDatasetDOMapper.countByExample(example);
    }

    public List<LlmOpsDatasetDO> getDatasetList(Integer limit, Integer offset, String accountId, String searchWord) {
        LlmOpsDatasetDOExample example = new LlmOpsDatasetDOExample();
        example.setOffset(offset);
        example.setRows(limit);
        LlmOpsDatasetDOExample.Criteria criteria = example.createCriteria();
        criteria.andAccountIdEqualTo(accountId);
        if (StringUtils.isNoneBlank(searchWord)) {
            criteria.andNameLike("%" + searchWord + "%");
        }
        return llmOpsDatasetDOMapper.selectByExample(example);
    }
}

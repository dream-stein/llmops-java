package com.emcikem.llm.service.provider;

import com.emcikem.llm.dao.entity.LlmOpsApiKeyDO;
import com.emcikem.llm.dao.example.LlmOpsApiKeyDOExample;
import com.emcikem.llm.dao.mapper.LlmOpsApiKeyDOMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Create with Emcikem on 2025/3/29
 *
 * @author Emcikem
 * @version 1.0.0
 */
@Service
public class LLMOpsApiKeyProvider {

    @Resource
    private LlmOpsApiKeyDOMapper llmOpsApiKeyDOMapper;

    public boolean insertApiKey(LlmOpsApiKeyDO llmOpsApiKeyDO) {
        return llmOpsApiKeyDOMapper.insert(llmOpsApiKeyDO) == 1;
    }

    public boolean deleteApiKey(String apiKeyId) {
        return llmOpsApiKeyDOMapper.deleteByPrimaryKey(apiKeyId) == 1;
    }

    public boolean updateApiKey(LlmOpsApiKeyDO record) {
        return llmOpsApiKeyDOMapper.updateByPrimaryKeySelective(record) == 1;
    }

    public List<LlmOpsApiKeyDO> getApiKeyList(Integer limit, Integer offset, String accountId) {
        LlmOpsApiKeyDOExample example = new LlmOpsApiKeyDOExample();
        example.setOffset(offset);
        example.setRows(limit);
        LlmOpsApiKeyDOExample.Criteria criteria = example.createCriteria();
        criteria.andAccountIdEqualTo(accountId);
        return llmOpsApiKeyDOMapper.selectByExample(example);
    }

    public Long countApiKeyList(String accountId) {
        LlmOpsApiKeyDOExample example = new LlmOpsApiKeyDOExample();
        example.createCriteria().andAccountIdEqualTo(accountId);
        return llmOpsApiKeyDOMapper.countByExample(example);
    }

    public LlmOpsApiKeyDO selectApiKeyByApiKey(String apiKeyId) {
        return llmOpsApiKeyDOMapper.selectByPrimaryKey(apiKeyId);
    }
}

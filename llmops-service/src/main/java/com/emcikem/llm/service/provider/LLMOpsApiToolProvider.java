package com.emcikem.llm.service.provider;

import com.emcikem.llm.dao.entity.LlmOpsApiToolDO;
import com.emcikem.llm.dao.entity.LlmOpsApiToolProviderDO;
import com.emcikem.llm.dao.example.LlmOpsApiToolDOExample;
import com.emcikem.llm.dao.example.LlmOpsApiToolProviderDOExample;
import com.emcikem.llm.dao.mapper.LlmOpsApiToolDOMapper;
import com.emcikem.llm.dao.mapper.LlmOpsApiToolProviderDOMapper;
import jakarta.annotation.Resource;
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
public class LLMOpsApiToolProvider {

    @Resource
    private LlmOpsApiToolDOMapper llmOpsApiToolDOMapper;

    @Resource
    private LlmOpsApiToolProviderDOMapper llmOpsApiToolProviderDOMapper;

    public Long countApiToolList(String accountId, String searchWord) {
        LlmOpsApiToolDOExample example = new LlmOpsApiToolDOExample();
        LlmOpsApiToolDOExample.Criteria criteria = example.createCriteria();
        criteria.andAccountIdEqualTo(accountId);
        if (StringUtils.isNoneEmpty(searchWord)) {
            criteria.andNameLike("%" + searchWord + "%");
        }
        return llmOpsApiToolDOMapper.countByExample(example);
    }

    public List<LlmOpsApiToolProviderDO> getApiToolProviderList(String searchWord, Integer limit, Integer offset, String accountId) {
        LlmOpsApiToolProviderDOExample example = new LlmOpsApiToolProviderDOExample();
        example.setOffset(offset);
        example.setRows(limit);
        LlmOpsApiToolProviderDOExample.Criteria criteria = example.createCriteria();
        criteria.andAccountIdEqualTo(accountId);
        if (StringUtils.isNoneEmpty(searchWord)) {
            criteria.andNameLike("%" + searchWord + "%");
        }
        return llmOpsApiToolProviderDOMapper.selectByExample(example);
    }
}

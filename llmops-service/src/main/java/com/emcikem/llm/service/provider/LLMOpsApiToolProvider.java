package com.emcikem.llm.service.provider;

import com.emcikem.llm.dao.entity.LlmOpsApiToolProviderDO;
import com.emcikem.llm.dao.example.LlmOpsApiToolProviderDOExample;
import com.emcikem.llm.dao.mapper.LlmOpsApiToolDOMapper;
import com.emcikem.llm.dao.mapper.LlmOpsApiToolProviderDOMapper;
import com.google.common.collect.Lists;
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
public class LLMOpsApiToolProvider {

    @Resource
    private LlmOpsApiToolDOMapper llmOpsApiToolDOMapper;

    @Resource
    private LlmOpsApiToolProviderDOMapper llmOpsApiToolProviderDOMapper;

    public Long countApiToolProviderList(String accountId, String searchWord) {
        LlmOpsApiToolProviderDOExample example = new LlmOpsApiToolProviderDOExample();
        LlmOpsApiToolProviderDOExample.Criteria criteria = example.createCriteria();
        criteria.andAccountIdEqualTo(accountId);
        if (StringUtils.isNoneEmpty(searchWord)) {
            criteria.andNameLike("%" + searchWord + "%");
        }
        return llmOpsApiToolProviderDOMapper.countByExample(example);
    }

    public LlmOpsApiToolProviderDO getApiToolProvider(String accountId, String providerId) {
        LlmOpsApiToolProviderDOExample example = new LlmOpsApiToolProviderDOExample();
        LlmOpsApiToolProviderDOExample.Criteria criteria = example.createCriteria();
        criteria.andAccountIdEqualTo(accountId);
        criteria.andIdEqualTo(providerId);
        List<LlmOpsApiToolProviderDO> llmOpsApiToolProviderList = llmOpsApiToolProviderDOMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(llmOpsApiToolProviderList)) {
            return null;
        }
        return llmOpsApiToolProviderList.get(0);
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

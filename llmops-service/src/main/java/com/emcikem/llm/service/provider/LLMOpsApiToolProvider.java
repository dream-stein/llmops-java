package com.emcikem.llm.service.provider;

import com.emcikem.llm.dao.entity.LlmOpsApiToolDO;
import com.emcikem.llm.dao.example.LlmOpsApiToolDOExample;
import com.emcikem.llm.dao.example.LlmOpsApiToolProviderDOExample;
import com.emcikem.llm.dao.mapper.LlmOpsApiToolDOMapper;
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

    public Long countApiToolList(String accountId, String searchWord) {
        LlmOpsApiToolDOExample example = new LlmOpsApiToolDOExample();
        LlmOpsApiToolDOExample.Criteria criteria = example.createCriteria();
        criteria.andAccountIdEqualTo(accountId);
        if (StringUtils.isNoneEmpty(searchWord)) {
            criteria.andNameLike("%" + searchWord + "%");
        }
        return llmOpsApiToolDOMapper.countByExample(example);
    }

    public List<LlmOpsApiToolDO> getApiToolProviderList(String searchWord, Integer limit, Integer offset, String accountId) {
        LlmOpsApiToolDOExample example = new LlmOpsApiToolDOExample();
        example.setOffset(offset);
        example.setRows(limit);
        LlmOpsApiToolDOExample.Criteria criteria = example.createCriteria();
        criteria.andAccountIdEqualTo(accountId);
        if (StringUtils.isNoneEmpty(searchWord)) {
            criteria.andNameLike("%" + searchWord + "%");
        }
        return llmOpsApiToolDOMapper.selectByExample(example);
    }
}

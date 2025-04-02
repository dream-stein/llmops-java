package com.emcikem.llm.service.provider;

import com.emcikem.llm.dao.entity.LlmOpsApiKeyDO;
import com.emcikem.llm.dao.entity.LlmOpsAppDO;
import com.emcikem.llm.dao.entity.LlmOpsDatasetDO;
import com.emcikem.llm.dao.example.LlmOpsApiKeyDOExample;
import com.emcikem.llm.dao.example.LlmOpsAppDOExample;
import com.emcikem.llm.dao.example.LlmOpsDatasetDOExample;
import com.emcikem.llm.dao.mapper.LlmOpsAppDOMapper;
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
public class LLMOpsAppProvider {

    @Resource
    private LlmOpsAppDOMapper llmOpsAppDOMapper;

    public LlmOpsAppDO getApp(String appId, String accountId) {
        LlmOpsAppDOExample example = new LlmOpsAppDOExample();
        LlmOpsAppDOExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(appId);
        criteria.andAccountIdEqualTo(accountId);
        List<LlmOpsAppDO> llmOpsAppList = llmOpsAppDOMapper.selectByExampleWithBLOBs(example);
        if (CollectionUtils.isEmpty(llmOpsAppList)) {
            return null;
        }
        return llmOpsAppList.get(0);
    }

    public Long countAppList(String accountId, String searchWord) {
        LlmOpsAppDOExample example = new LlmOpsAppDOExample();
        LlmOpsAppDOExample.Criteria criteria = example.createCriteria();
        criteria.andAccountIdEqualTo(accountId);
        if (StringUtils.isNoneBlank(searchWord)) {
            criteria.andNameLike("%" + searchWord + "%");
        }
        return llmOpsAppDOMapper.countByExample(example);
    }

    public List<LlmOpsAppDO> getAppList(Integer limit, Integer offset, String accountId, String searchWord) {
        LlmOpsAppDOExample example = new LlmOpsAppDOExample();
        example.setOffset(offset);
        example.setRows(limit);
        LlmOpsAppDOExample.Criteria criteria = example.createCriteria();
        criteria.andAccountIdEqualTo(accountId);
        if (StringUtils.isNoneBlank(searchWord)) {
            criteria.andNameLike("%" + searchWord + "%");
        }
        return llmOpsAppDOMapper.selectByExampleWithBLOBs(example);
    }

    public boolean deleteApp(String accountId, String appId) {
        LlmOpsAppDOExample example = new LlmOpsAppDOExample();
        LlmOpsAppDOExample.Criteria criteria = example.createCriteria();
        criteria.andAccountIdEqualTo(accountId);
        criteria.andIdEqualTo(appId);
        return llmOpsAppDOMapper.deleteByExample(example) == 1;
    }

    public boolean updateApp(String accountId, String appId, LlmOpsAppDO llmOpsAppDO) {
        LlmOpsAppDOExample example = new LlmOpsAppDOExample();
        LlmOpsAppDOExample.Criteria criteria = example.createCriteria();
        criteria.andAccountIdEqualTo(accountId);
        criteria.andIdEqualTo(appId);

        return llmOpsAppDOMapper.updateByExampleSelective(llmOpsAppDO, example) == 1;
    }

    public boolean createApp(LlmOpsAppDO llmOpsAppDO) {
        return llmOpsAppDOMapper.insert(llmOpsAppDO) == 1;
    }
}

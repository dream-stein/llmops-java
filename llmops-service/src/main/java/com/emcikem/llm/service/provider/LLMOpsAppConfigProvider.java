package com.emcikem.llm.service.provider;

import com.emcikem.llm.dao.entity.LlmOpsAppConfigDO;
import com.emcikem.llm.dao.example.LlmOpsAppConfigDOExample;
import com.emcikem.llm.dao.mapper.LlmOpsAppConfigDOMapper;
import jakarta.annotation.Resource;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Create with Emcikem on 2025/4/5
 *
 * @author Emcikem
 * @version 1.0.0
 */
@Service
public class LLMOpsAppConfigProvider {

    @Resource
    private LlmOpsAppConfigDOMapper llmOpsAppConfigDOMapper;

    public LlmOpsAppConfigDO getDraftAppConfig(String appId) {
        LlmOpsAppConfigDOExample example = new LlmOpsAppConfigDOExample();
        LlmOpsAppConfigDOExample.Criteria criteria = example.createCriteria();
        criteria.andAppIdEqualTo(appId);

        List<LlmOpsAppConfigDO> llmOpsAppConfigList = llmOpsAppConfigDOMapper.selectByExampleWithBLOBs(example);
        if (CollectionUtils.isEmpty(llmOpsAppConfigList)) {
            return null;
        }
        return llmOpsAppConfigList.get(0);
    }

    public boolean updateDraftAppConfig(String appId, LlmOpsAppConfigDO appConfigDO) {
        LlmOpsAppConfigDOExample example = new LlmOpsAppConfigDOExample();
        LlmOpsAppConfigDOExample.Criteria criteria = example.createCriteria();
        criteria.andAppIdEqualTo(appId);
        return llmOpsAppConfigDOMapper.updateByExampleSelective(appConfigDO, example) == 1;
    }

    public boolean createAppConfig(LlmOpsAppConfigDO llmOpsAppConfigDO) {
        return llmOpsAppConfigDOMapper.insert(llmOpsAppConfigDO) == 1;
    }
}

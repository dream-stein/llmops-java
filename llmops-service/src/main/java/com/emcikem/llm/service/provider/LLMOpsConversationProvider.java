package com.emcikem.llm.service.provider;

import com.emcikem.llm.dao.entity.LlmOpsConversationDO;
import com.emcikem.llm.dao.example.LlmOpsConversationDOExample;
import com.emcikem.llm.dao.mapper.LlmOpsConversationDOMapper;
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
public class LLMOpsConversationProvider {

    @Resource
    private LlmOpsConversationDOMapper llmOpsConversationDOMapper;

    public LlmOpsConversationDO getConversation(String appId) {
        LlmOpsConversationDOExample example = new LlmOpsConversationDOExample();
        LlmOpsConversationDOExample.Criteria criteria = example.createCriteria();
        criteria.andAppIdEqualTo(appId);
        criteria.andIsDeleteEqualTo(false);
        List<LlmOpsConversationDO> llmOpsConversationList = llmOpsConversationDOMapper.selectByExampleWithBLOBs(example);
        if (CollectionUtils.isEmpty(llmOpsConversationList)) {
            return null;
        }
        return llmOpsConversationList.get(0);
    }

    public boolean updateConversation(String appId, LlmOpsConversationDO llmOpsConversationDO) {
        LlmOpsConversationDOExample example = new LlmOpsConversationDOExample();
        LlmOpsConversationDOExample.Criteria criteria = example.createCriteria();
        criteria.andAppIdEqualTo(appId);
        criteria.andIsDeleteEqualTo(false);
        return llmOpsConversationDOMapper.updateByExampleSelective(llmOpsConversationDO, example) == 1;
    }

}

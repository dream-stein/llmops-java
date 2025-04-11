package com.emcikem.llm.service.convert;

import com.emcikem.llm.common.vo.assistantagent.AssistantAgentMessagesVO;
import com.emcikem.llm.dao.entity.LlmOpsMessageDO;
import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Create with Emcikem on 2025/4/9
 *
 * @author Emcikem
 * @version 1.0.0
 */
public class LLMOpsAssistantConvert {


    public static List<AssistantAgentMessagesVO> convert2MessageList(List<LlmOpsMessageDO> llmOpsMessageList) {
        if (CollectionUtils.isEmpty(llmOpsMessageList)) {
            return Lists.newArrayList();
        }
        return llmOpsMessageList.stream().map(LLMOpsAssistantConvert::convert2Message).filter(Objects::nonNull).collect(Collectors.toList());
    }

    public static AssistantAgentMessagesVO convert2Message(LlmOpsMessageDO llmOpsMessageDO) {
        if (llmOpsMessageDO == null) {
            return null;
        }
        AssistantAgentMessagesVO assistantAgentMessagesVO = new AssistantAgentMessagesVO();
        assistantAgentMessagesVO.setId(llmOpsMessageDO.getId());
        assistantAgentMessagesVO.setLatency((long) (llmOpsMessageDO.getLatency() * 100));
        assistantAgentMessagesVO.setAnswer(llmOpsMessageDO.getAnswer());
        assistantAgentMessagesVO.setQuery(llmOpsMessageDO.getQuery());
        assistantAgentMessagesVO.setConversation_id(llmOpsMessageDO.getConversation());
        assistantAgentMessagesVO.setCreated_at(llmOpsMessageDO.getCreatedAt().getTime());
        assistantAgentMessagesVO.setTotal_token_count(Long.valueOf(llmOpsMessageDO.getTotalTokenCount()));
        assistantAgentMessagesVO.setAgent_thoughts(Lists.newArrayList());
        return assistantAgentMessagesVO;
    }
}

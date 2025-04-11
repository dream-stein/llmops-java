package com.emcikem.llm.service.provider;

import com.emcikem.llm.dao.entity.LlmOpsMessageDO;
import com.emcikem.llm.dao.example.LlmOpsMessageDOExample;
import com.emcikem.llm.dao.mapper.LlmOpsMessageDOMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Create with Emcikem on 2025/4/5
 *
 * @author Emcikem
 * @version 1.0.0
 */
@Service
public class LLMOpsMessageProvider {

    @Resource
    private LlmOpsMessageDOMapper llmOpsMessageDOMapper;

    public List<LlmOpsMessageDO> getMessageList(Integer offset, Integer pageSize, Long createdAt, String assistantConversationId) {
        LlmOpsMessageDOExample example = new LlmOpsMessageDOExample();
        example.setRows(pageSize);
        example.setOffset(offset);
        LlmOpsMessageDOExample.Criteria criteria = example.createCriteria();
        criteria.andConversationEqualTo(assistantConversationId);
        return llmOpsMessageDOMapper.selectByExampleWithBLOBs(example);
    }

    public Long countMessageList(Long createdAt, String assistantConversationId) {
        LlmOpsMessageDOExample example = new LlmOpsMessageDOExample();
        LlmOpsMessageDOExample.Criteria criteria = example.createCriteria();
        criteria.andConversationEqualTo(assistantConversationId);
        return llmOpsMessageDOMapper.countByExample(example);
    }
}

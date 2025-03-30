package com.emcikem.llm.service.provider;

import com.emcikem.llm.common.vo.workflow.WorkflowVO;
import com.emcikem.llm.dao.entity.LlmOpsWorkflowDO;
import com.emcikem.llm.dao.example.LlmOpsWorkflowDOExample;
import com.emcikem.llm.dao.mapper.LlmOpsWorkflowDOMapper;
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
public class LLMOpsWorkflowProvider {

    @Resource
    private LlmOpsWorkflowDOMapper llmOpsWorkflowDOMapper;

    public Long countWorkflowList(String accountId, String searchWord) {
        LlmOpsWorkflowDOExample example = new LlmOpsWorkflowDOExample();
        LlmOpsWorkflowDOExample.Criteria criteria = example.createCriteria();
        criteria.andAccountIdEqualTo(accountId);
        if (StringUtils.isNoneEmpty(searchWord)) {
            criteria.andNameLike("%" + searchWord + "%");
        }
        return llmOpsWorkflowDOMapper.countByExample(example);
    }

    public List<LlmOpsWorkflowDO> getWorkflowList(Integer pageSize, Integer offset, String accountId, String searchWord) {
        LlmOpsWorkflowDOExample example = new LlmOpsWorkflowDOExample();
        example.setRows(pageSize);
        example.setOffset(offset);
        LlmOpsWorkflowDOExample.Criteria criteria = example.createCriteria();
        criteria.andAccountIdEqualTo(accountId);
        if (StringUtils.isNoneEmpty(searchWord)) {
            criteria.andNameLike("%" + searchWord + "%");
        }
        return llmOpsWorkflowDOMapper.selectByExample(example);
    }
}

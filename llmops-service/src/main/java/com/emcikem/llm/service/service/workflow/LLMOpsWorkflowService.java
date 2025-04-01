package com.emcikem.llm.service.service.workflow;

import com.emcikem.llm.common.entity.ApiBasePaginatorResponse;
import com.emcikem.llm.common.entity.Paginator;
import com.emcikem.llm.common.vo.workflow.WorkflowVO;
import com.emcikem.llm.dao.entity.LlmOpsDatasetDO;
import com.emcikem.llm.dao.entity.LlmOpsWorkflowDO;
import com.emcikem.llm.service.convert.LLMOpsDatasetConvert;
import com.emcikem.llm.service.convert.LLMOpsWorkflowConvert;
import com.emcikem.llm.service.provider.LLMOpsWorkflowProvider;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Create with Emcikem on 2025/3/28
 *
 * @author Emcikem
 * @version 1.0.0
 */
@Service
public class LLMOpsWorkflowService {

    @Resource
    private LLMOpsWorkflowProvider llmOpsWorkflowProvider;

    public ApiBasePaginatorResponse<WorkflowVO> getWorkflowsWithPage(String searchWord, Integer currentPage, Integer pageSize, String status) {
        // 1. 查询当前账号
        String accountId = getAccountId();

        // 2. 数据查询
        Long count = llmOpsWorkflowProvider.countWorkflowList(accountId, searchWord, status);
        Integer offset = (currentPage - 1) * pageSize;
        List<LlmOpsWorkflowDO> workflowList = llmOpsWorkflowProvider.getWorkflowList(pageSize, offset, accountId, searchWord, status);

        Paginator paginator = new Paginator();
        paginator.setCurrent_page(currentPage);
        paginator.setPage_size(pageSize);
        paginator.setTotal_record(count);
        paginator.setTotal_page((int) ((count + pageSize - 1) / pageSize));

        return ApiBasePaginatorResponse.success(LLMOpsWorkflowConvert.convert(workflowList), paginator);
    }

    public WorkflowVO getWorkflow(String workflowId) {
        // 1. 查询当前账号
        String accountId = getAccountId();

        // 2. 查询数据
        LlmOpsWorkflowDO workflow = llmOpsWorkflowProvider.getWorkflow(workflowId, accountId);

        return LLMOpsWorkflowConvert.convert(workflow);
    }

    private String getAccountId() {
        return "1";
    }
}

package com.emcikem.llm.web.controller;

import com.emcikem.llm.common.entity.ApiBasePaginatorResponse;
import com.emcikem.llm.common.entity.ApiResponse;
import com.emcikem.llm.common.vo.workflow.WorkflowVO;
import com.emcikem.llm.service.service.workflow.LLMOpsWorkflowService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

/**
 * Create with Emcikem on 2025/3/28
 *
 * @author Emcikem
 * @version 1.0.0
 */
@RestController
@RequestMapping("/workflows")
public class LLMOpsWorkflowController {

    @Resource
    private LLMOpsWorkflowService llmOpsWorkflowService;

    @GetMapping
    public ApiBasePaginatorResponse<WorkflowVO> getWorkflowsWithPage(@RequestParam(value = "search_word", required = false) String searchWord,
                                                                     @RequestParam("current_page") Integer currentPage,
                                                                     @RequestParam("page_size") Integer pageSize,
                                                                     @RequestParam("status") String status) {
        return llmOpsWorkflowService.getWorkflowsWithPage(searchWord, currentPage, pageSize, status);
    }

    @GetMapping("/{workflow_id}")
    public ApiResponse<WorkflowVO> getWorkflow(@PathVariable("workflow_id") String workflowId) {
        return ApiResponse.success(llmOpsWorkflowService.getWorkflow(workflowId));
    }
}

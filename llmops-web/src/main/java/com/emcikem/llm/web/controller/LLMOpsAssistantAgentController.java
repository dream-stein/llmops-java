package com.emcikem.llm.web.controller;

import com.emcikem.llm.common.entity.ApiBasePaginatorResponse;
import com.emcikem.llm.common.entity.ApiResponse;
import com.emcikem.llm.common.vo.assistantagent.AssistantAgentMessagesVO;
import com.emcikem.llm.service.service.assistantagent.LLMOpsAssistantAgentService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

/**
 * Create with Emcikem on 2025/3/28
 *
 * @author Emcikem
 * @version 1.0.0
 */
@RestController
@RequestMapping("/assistant-agent")
public class LLMOpsAssistantAgentController {

    @Resource
    private LLMOpsAssistantAgentService llmOpsAssistantAgentService;

    @PostMapping("/chat")
    public void assistantAgentChat() {

    }

    @PostMapping("/chat/{task_id}/stop")
    public ApiResponse<Void> stopAssistantAgentChat(@PathVariable("task_id") String taskId) {
        return ApiResponse.success(null);
    }

    @GetMapping("/messages")
    public ApiBasePaginatorResponse<AssistantAgentMessagesVO> getAssistantAgentMessagesWithPage(@RequestParam("current_page") Integer currentPage,
                                                                                                @RequestParam("page_size") Integer pageSize,
                                                                                                @RequestParam("created_at") Long createdAt) {
        return llmOpsAssistantAgentService.getAssistantAgentMessagesWithPage(currentPage, pageSize, createdAt);
    }

    @PostMapping("/delete-conversation")
    public ApiResponse<Void> deleteAssistantAgentConversation() {
        return ApiResponse.success(null);
    }
}

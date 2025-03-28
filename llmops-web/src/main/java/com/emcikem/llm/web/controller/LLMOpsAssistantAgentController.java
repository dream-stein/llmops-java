package com.emcikem.llm.web.controller;

import com.emcikem.llm.common.entity.ApiBasePaginatorResponse;
import com.emcikem.llm.common.entity.ApiResponse;
import com.emcikem.llm.common.vo.assistantagent.GetAssistantAgentMessagesVO;
import com.emcikem.llm.common.vo.assistantagent.GetAssistantAgentMessagesWithPageParam;
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

    @PostMapping("/chat")
    public void assistantAgentChat() {

    }

    @PostMapping("/chat/{task_id}/stop")
    public ApiResponse<Void> stopAssistantAgentChat(@PathVariable("task_id") String taskId) {
        return ApiResponse.success(null);
    }

    @GetMapping("/messages")
    public ApiBasePaginatorResponse<GetAssistantAgentMessagesVO> getAssistantAgentMessagesWithPage(@RequestBody GetAssistantAgentMessagesWithPageParam param) {
        return new ApiBasePaginatorResponse<>();
    }

    @PostMapping("/delete-conversation")
    public ApiResponse<Void> deleteAssistantAgentConversation() {
        return ApiResponse.success(null);
    }
}

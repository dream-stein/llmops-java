package com.emcikem.llm.web.controller;

import com.emcikem.llm.common.entity.ApiResponse;
import com.emcikem.llm.common.vo.AiChatResponse;
import com.emcikem.llm.common.vo.ChatVO;
import com.emcikem.llm.service.service.ChatAssistService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

/**
 * 对话接口
 */
@RestController
@RequestMapping("/assistant")
public class AssistantController {

    @Resource
    private ChatAssistService chatAssistService;

    @PostMapping(value = "/chat")
    public ApiResponse<AiChatResponse> chat(@RequestBody ChatVO chatVO) {
        String chat = chatAssistService.chat(chatVO);
        AiChatResponse response = new AiChatResponse();
        response.setContent(chat);
        return ApiResponse.success(response);
    }
}

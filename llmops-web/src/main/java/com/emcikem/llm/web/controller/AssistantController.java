package com.emcikem.llm.web.controller;

import com.emcikem.llm.common.vo.ChatVO;
import com.emcikem.llm.service.aiservice.Assistant;
import com.emcikem.llm.service.aiservice.StreamingAssistant;
import com.emcikem.llm.service.service.ChatAssistService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import static org.springframework.http.MediaType.TEXT_EVENT_STREAM_VALUE;

/**
 * 对话接口
 */
@RestController
@RequestMapping("/assistant")
public class AssistantController {

    private StreamingAssistant streamingAssistant;

    AssistantController(StreamingAssistant streamingAssistant) {
        this.streamingAssistant = streamingAssistant;
    }

    @GetMapping("/assistant")
    public String assistant(@RequestParam(value = "message", defaultValue = "What time is it now?") String message) {
        ChatVO chatVO = new ChatVO();
//        chatVO.setDialogId(2L);
        chatVO.setModelType(2);
        chatVO.setPrompt(message);
        chatVO.setTenantId(1L);
        return chatAssistService.chat(chatVO);
    }

    @GetMapping(value = "/streamingAssistant", produces = TEXT_EVENT_STREAM_VALUE)
    public Flux<String> streamingAssistant(
            @RequestParam(value = "message", defaultValue = "Tell me an interesting story in 100 words") String message) {
        return streamingAssistant.chat(message);
    }

    public void chatHistory() {
        return;
    }


    @Resource
    private ChatAssistService chatAssistService;

    @PostMapping(value = "/chat")
    public String chat(@RequestBody ChatVO chatVO) {
        return chatAssistService.chat(chatVO);
    }
}

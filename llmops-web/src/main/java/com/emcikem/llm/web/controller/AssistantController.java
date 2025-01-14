package com.emcikem.llm.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Create with Emcikem on 2024/11/20
 *
 * @author Emcikem
 * @version 1.0.0
 */
@RestController
class AssistantController {
    https://pan.baidu.com/s/1GGYdHrMcqiV81E7LlqP03Q?pwd=qs8m#list/path=%2Fsharelink2345894990-294148699323841%2F89226-LLM%E5%BA%94%E7%94%A8%E5%BC%80%E5%8F%91%E5%B9%B3%E5%8F%B0%E7%89%B9%E8%AE%AD%E8%90%A5%EF%BC%88%E6%8C%81%E7%BB%AD%E6%9B%B4%E6%96%B0%E4%B8%AD%EF%BC%89&parentPath=%2Fsharelink2345894990-294148699323841
    Assistant assistant;
    StreamingAssistant streamingAssistant;

    AssistantController(Assistant assistant, StreamingAssistant streamingAssistant) {
        this.assistant = assistant;
        this.streamingAssistant = streamingAssistant;
    }

    @GetMapping("/assistant")
    public String assistant(@RequestParam(value = "message", defaultValue = "What time is it now?") String message) {
        return assistant.chat(message);
    }

    @GetMapping(value = "/streamingAssistant", produces = TEXT_EVENT_STREAM_VALUE)
    public Flux<String> streamingAssistant(
            @RequestParam(value = "message", defaultValue = "Tell me an interesting story in 100 words") String message) {
        return streamingAssistant.chat(message);
    }
}

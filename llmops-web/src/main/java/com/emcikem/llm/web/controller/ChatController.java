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
public class ChatController {

    @Resource
//    private ChatLanguageModel chatLanguageModel;

    @GetMapping("/chat")
    public String model(@RequestParam(value = "message", defaultValue = "Hello") String message) {
//        return chatLanguageModel.generate(message);
        return null;
    }
}

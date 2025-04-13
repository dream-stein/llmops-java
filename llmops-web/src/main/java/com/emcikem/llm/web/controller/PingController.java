package com.emcikem.llm.web.controller;

import com.emcikem.llm.service.service.dataset.LLMOpsDatabaseFileService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }

    @Resource
    private LLMOpsDatabaseFileService llmOpsDatabaseFileService;

    @GetMapping("/x")
    public void get(String name) {
        llmOpsDatabaseFileService.loadDocument(name);
    }
}

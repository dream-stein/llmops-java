package com.emcikem.llm.web.controller;

import com.emcikem.llm.service.service.dataset.LLMOpsDocumentLoaderService;
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
    private LLMOpsDocumentLoaderService llmOpsDocumentLoaderService;

    @GetMapping("/x")
    public void get(String name) {
        llmOpsDocumentLoaderService.loadDocument(name, "1");
    }
}

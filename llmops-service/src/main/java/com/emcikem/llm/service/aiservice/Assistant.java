package com.emcikem.llm.service.aiservice;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.spring.AiService;

@AiService
public interface Assistant {

    @SystemMessage("你是一个资深的后端程序员")
    String chat(String userMessage);
}
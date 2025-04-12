package com.emcikem.llm.service.aiservice;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.TokenStream;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;
import reactor.core.publisher.Flux;

@AiService
public interface Assistant {

    @SystemMessage("你是一个资深的后端程序员")
    String chat(@MemoryId Long memoryId, @UserMessage String userMessage);

    @SystemMessage("你是一个通用的AI辅助智能体，可以调用各种工具以及知识库，来帮助用户实现各种需求")
    TokenStream streamChat(@MemoryId Long memoryId, @UserMessage String userMessage);
}
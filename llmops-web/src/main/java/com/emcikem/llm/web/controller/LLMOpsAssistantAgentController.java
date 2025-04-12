package com.emcikem.llm.web.controller;

import com.emcikem.llm.common.entity.ApiBasePaginatorResponse;
import com.emcikem.llm.common.entity.ApiResponse;
import com.emcikem.llm.common.enums.ChatModelEnum;
import com.emcikem.llm.common.vo.assistantagent.AssistantAgentMessagesVO;
import com.emcikem.llm.service.aiservice.Assistant;
import com.emcikem.llm.service.aiservice.factory.AssistantFactory;
import com.emcikem.llm.service.service.assistantagent.LLMOpsAssistantAgentService;
import dev.langchain4j.data.message.ChatMessage;
import dev.langchain4j.data.message.SystemMessage;
import dev.langchain4j.model.chat.StreamingChatLanguageModel;
import dev.langchain4j.model.chat.request.ChatRequest;
import dev.langchain4j.model.chat.response.ChatResponse;
import dev.langchain4j.model.chat.response.StreamingChatResponseHandler;
import dev.langchain4j.model.openai.OpenAiStreamingChatModel;
import dev.langchain4j.service.TokenStream;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static dev.langchain4j.data.message.SystemMessage.systemMessage;
import static dev.langchain4j.data.message.UserMessage.userMessage;
import static java.util.Arrays.asList;

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

    @Resource
    private AssistantFactory assistantFactory;

    @GetMapping(value = "/chat", produces = "text/stream;charset=UTF-8")
    public Flux<String> assistantAgentChat(String message) {
        Assistant assistant = assistantFactory.getAssistant(ChatModelEnum.DEEP_SEEK.getModelName());
        TokenStream tokenStream = assistant.streamChat(1L, message);
        return Flux.create(sink -> {
            tokenStream.onPartialResponse(sink::next)
                    .onCompleteResponse(c -> sink.complete())
                    .onError(sink::error)
                    .start();
        });
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

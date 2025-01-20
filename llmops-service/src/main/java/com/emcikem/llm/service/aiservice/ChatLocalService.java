package com.emcikem.llm.service.aiservice;

import com.emcikem.llm.service.aiservice.factory.ChatLanguageModelFactory;
import dev.langchain4j.memory.chat.ChatMemoryProvider;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.AiServices;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * Create with Emcikem on 2025/1/20
 *
 * @author Emcikem
 * @version 1.0.0
 */
@Service
public class ChatLocalService {

    @Resource
    private PersistentChatMemoryStore persistentChatMemoryStore;

    @Resource
    private ChatLanguageModelFactory chatLanguageModelFactory;

    private final Assistant assistant;

    public ChatLocalService() {
        ChatMemoryProvider chatMemoryProvider = memoryId -> MessageWindowChatMemory.builder()
                .id(memoryId)
                .maxMessages(10)
                .chatMemoryStore(persistentChatMemoryStore)
                .build();

        ChatLanguageModel model = OpenAiChatModel.builder()
                .apiKey("")
                .modelName("")
                .build();

        assistant = AiServices.builder(Assistant.class)
                .chatLanguageModel(model)
                .chatMemoryProvider(chatMemoryProvider)
                .build();
    }

    public String chat(Long memoryId, String userMessage) {
        return assistant.chat(memoryId, userMessage);
    }
}

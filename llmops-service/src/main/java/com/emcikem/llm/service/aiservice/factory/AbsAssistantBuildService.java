package com.emcikem.llm.service.aiservice.factory;

import com.emcikem.llm.common.enums.ChatModelEnum;
import com.emcikem.llm.service.aiservice.Assistant;
import com.emcikem.llm.service.aiservice.PersistentChatMemoryStore;
import com.google.common.collect.Lists;
import dev.langchain4j.memory.chat.ChatMemoryProvider;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.AiServices;
import jakarta.annotation.Resource;

/**
 * Create with Emcikem on 2025/1/20
 *
 * @author Emcikem
 * @version 1.0.0
 */
public abstract class AbsAssistantBuildService implements AssistantBuildService {

    @Resource
    private PersistentChatMemoryStore persistentChatMemoryStore;

    @Override
    public String getModelName() {
        return getChatModelEnum().getModelName();
    }

    @Override
    public Assistant getAssistant() {
        ChatMemoryProvider chatMemoryProvider = memoryId -> MessageWindowChatMemory.builder()
                .id(memoryId)
                .maxMessages(10)
                .chatMemoryStore(persistentChatMemoryStore)
                .build();

        ChatLanguageModel model = getLanguageModel();

        return AiServices.builder(Assistant.class)
                .chatLanguageModel(model)
                .chatMemoryProvider(chatMemoryProvider)
                .tools(Lists.newArrayList())
                .build();
    }

    protected ChatLanguageModel getLanguageModel() {
        return OpenAiChatModel.builder()
                .baseUrl(getChatModelEnum().getBaseUrl())
                .apiKey(getApiKey())
                .modelName(getChatModelEnum().getModelName())
                .build();
    }

    abstract String getApiKey();

    abstract ChatModelEnum getChatModelEnum();
}

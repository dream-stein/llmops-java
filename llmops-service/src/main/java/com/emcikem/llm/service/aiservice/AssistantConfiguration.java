package com.emcikem.llm.service.aiservice;

import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AssistantConfiguration {

    @Resource
    private PersistentChatMemoryStore persistentChatMemoryStore;

    /**
     * This chat memory will be used by an {@link Assistant}
     */
    @Bean
    public ChatMemory chatMemory() {
        return MessageWindowChatMemory.builder()
                .id(12345L)
                .maxMessages(10)
                .chatMemoryStore(persistentChatMemoryStore)
                .build();
    }
}

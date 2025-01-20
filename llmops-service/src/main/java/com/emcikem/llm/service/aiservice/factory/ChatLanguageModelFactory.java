package com.emcikem.llm.service.aiservice.factory;

import dev.langchain4j.model.chat.ChatLanguageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Create with Emcikem on 2025/1/20
 *
 * @author Emcikem
 * @version 1.0.0
 */
@Service
public class ChatLanguageModelFactory {

    public final Map<String, ChatLanguageModel> chatLanguageModelMap;

    @Autowired
    public ChatLanguageModelFactory(List<ChatLanguageModelInterface> modelInterfaceList) {
        this.chatLanguageModelMap = modelInterfaceList.stream()
                .collect(Collectors
                        .toMap(ChatLanguageModelInterface::getModel, ChatLanguageModelInterface::getChatLanguageModel, (a, b) -> a));
    }

    public ChatLanguageModel getChatLanguageModel(String modelName) {
        return chatLanguageModelMap.get(modelName);
    }
}

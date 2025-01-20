package com.emcikem.llm.service.aiservice.factory;

import dev.langchain4j.model.chat.ChatLanguageModel;

/**
 * Create with Emcikem on 2025/1/20
 *
 * @author Emcikem
 * @version 1.0.0
 */
public interface ChatLanguageModelInterface {

    ChatLanguageModel getChatLanguageModel();

    String getModel();
}

package com.emcikem.llm.service.aiservice.factory;

import com.emcikem.llm.service.aiservice.Assistant;

/**
 * Create with Emcikem on 2025/1/20
 *
 * @author Emcikem
 * @version 1.0.0
 */
public interface AssistantBuildService {

    Assistant getAssistant();

    String getModelName();
}

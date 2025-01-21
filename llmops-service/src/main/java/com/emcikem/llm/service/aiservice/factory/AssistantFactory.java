package com.emcikem.llm.service.aiservice.factory;

import com.emcikem.llm.service.aiservice.Assistant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class AssistantFactory {

    private final Map<String, Assistant> assistantMap;

    @Autowired
    public AssistantFactory(List<AssistantBuildService> assistantBuildServices) {
        this.assistantMap = assistantBuildServices.stream()
                .collect(Collectors
                        .toMap(AssistantBuildService::getModelName, AssistantBuildService::getAssistant, (a, b) -> a));
    }

    public Assistant getAssistant(String modelName) {
        return assistantMap.get(modelName);
    }
}

package com.emcikem.llm.service.aiservice.factory;

import com.emcikem.llm.common.enums.ChatModelEnum;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Create with Emcikem on 2025/1/20
 *
 * @author Emcikem
 * @version 1.0.0
 */
@Service
public class KimiBuildServiceImpl extends AbsAssistantBuildService {

    @Value("${langchain4j.open-ai.chat-model.kimi-api-key}")
    private String apiKey;

    @Override
    ChatModelEnum getChatModelEnum() {
        return ChatModelEnum.KIMI;
    }

    @Override
    String getApiKey() {
        return this.apiKey;
    }


}

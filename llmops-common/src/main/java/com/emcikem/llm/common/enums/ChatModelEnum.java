package com.emcikem.llm.common.enums;

import java.util.Arrays;

/**
 * Create with Emcikem on 2025/1/20
 *
 * @author Emcikem
 * @version 1.0.0
 */
public enum ChatModelEnum {
    DEEP_SEEK(1, "deepseek-chat", "https://api.deepseek.com"),
    ;

    private final Integer modeId;

    private final String modelName;

    private final String baseUrl;

    ChatModelEnum(Integer modeId, String modelName, String baseUrl) {
        this.modeId = modeId;
        this.modelName = modelName;
        this.baseUrl = baseUrl;
    }

    public Integer getModeId() {
        return modeId;
    }

    public String getModelName() {
        return modelName;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public static ChatModelEnum findByModeId(Integer modelId) {
        return Arrays.stream(values()).filter(x -> x.getModeId().equals(modelId))
                .findFirst()
                .orElse(null);
    }
}

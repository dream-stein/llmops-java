package com.emcikem.llm.common.enums;

/**
 * Create with Emcikem on 2025/4/7
 *
 * @author Emcikem
 * @version 1.0.0
 */
public enum RetrievalStrategyEnum {
    FULL_TEXT(1, "full_text"),
    SEMANTIC(2, "semantic"),
    HYBRID(3, "hybrid"),

    ;

    private final Integer type;

    private final String value;

    RetrievalStrategyEnum(Integer type, String value) {
        this.type = type;
        this.value = value;
    }

    public Integer getType() {
        return type;
    }

    public String getValue() {
        return value;
    }
}

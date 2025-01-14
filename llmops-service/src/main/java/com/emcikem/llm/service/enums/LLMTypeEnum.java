package com.emcikem.llm.service.enums;

/**
 * Create with Emcikem on 2024/11/22
 *
 * @author Emcikem
 * @version 1.0.0
 */
public enum LLMTypeEnum {
    GPT(1, "gpt"),
    ;

    private final Integer type;

    private final String desc;

    LLMTypeEnum(Integer type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public Integer getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }
}

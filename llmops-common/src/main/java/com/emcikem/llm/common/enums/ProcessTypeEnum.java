package com.emcikem.llm.common.enums;

/**
 * Create with Emcikem on 2025/5/21
 *
 * @author Emcikem
 * @version 1.0.0
 */
public enum ProcessTypeEnum {

    AUTOMATIC(1, "automatic"),
    CUSTOM(2, "custom");

    private final Integer type;

    private final String desc;

    ProcessTypeEnum(Integer type, String desc) {
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

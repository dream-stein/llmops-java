package com.emcikem.llm.common.enums;

/**
 * Create with Emcikem on 2025/5/24
 *
 * @author Emcikem
 * @version 1.0.0
 */
public enum PreProcessRuleEnum {

    REMOVE_EXTRA_SPACE(1, "remove_extra_space"),
    REMOVE_URL_AND_EMAIL(2, "remove_url_and_email"),
    ;

    private final Integer code;

    private final String desc;

    PreProcessRuleEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}

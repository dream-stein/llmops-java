package com.emcikem.llm.common.enums;

/**
 * Create with Emcikem on 2025/1/18
 *
 * @author Emcikem
 * @version 1.0.0
 */
public enum ChatMessageRoleTypeEnum {
    AI(1, "ai消息"),
    USER(2, "用户消息"),
    ;

    private final Integer role;

    private final String desc;

    ChatMessageRoleTypeEnum(Integer role, String desc) {
        this.role = role;
        this.desc = desc;
    }

    public Integer getRole() {
        return role;
    }

    public String getDesc() {
        return desc;
    }
}

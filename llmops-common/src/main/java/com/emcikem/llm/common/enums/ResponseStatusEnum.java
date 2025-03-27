package com.emcikem.llm.common.enums;

/**
 * Create with Emcikem on 2025/1/31
 *
 * @author Emcikem
 * @version 1.0.0
 */
public enum ResponseStatusEnum {

    SUCCESS(0, "成功"),
    SYSTEM_ERROR(1, "系统繁忙"),
    NOT_FOUND(2, "找不到"),
    UNAUTHORIZED(3, "未授权"),
    FORBIDDEN(4, "被禁止"),
    VALIDATE_ERROR(5, "验证错误"),
    ;

    private final int code;

    private final String msg;

    ResponseStatusEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}

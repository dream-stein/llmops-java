package com.emcikem.llm.common.enums;

/**
 * Create with Emcikem on 2025/5/17
 *
 * @author Emcikem
 * @version 1.0.0
 */
public enum LlmOpsResultEnum {

    /**
     * 系统异常
     */
    SUCCESS(0, "Success"),
    SYSTEM_ERROR(1, "system error"),
    INVALID_ARGUMENT(2, "invalid argument"),


    /**
     * 业务异常，知识库
     */
    DATASET_HAS_SAME_NAME(10001, "dataset has same name"),
    ;

    private final Integer code;

    private final String message;

    LlmOpsResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}

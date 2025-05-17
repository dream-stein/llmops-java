package com.emcikem.llm.common.enums;

/**
 * Create with Emcikem on 2025/5/17
 *
 * @author Emcikem
 * @version 1.0.0
 */
public enum DataBaseStatusEnum {
    WAITING(1, "等待中"),
    PARSING(2, "解析处理中"),
    SPLITTING(3, "分割中"),
    INDEXING(4, "构建索引中"),
    COMPLETED(5, "构建完成"),
    ERROR(6, "出错"),
    ;

    private final Integer status;

    private final String desc;

    DataBaseStatusEnum(Integer status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public Integer getStatus() {
        return status;
    }

    public String getDesc() {
        return desc;
    }
}

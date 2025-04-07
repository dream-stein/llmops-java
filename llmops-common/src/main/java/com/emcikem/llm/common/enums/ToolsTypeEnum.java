package com.emcikem.llm.common.enums;

/**
 * Create with Emcikem on 2025/4/7
 *
 * @author Emcikem
 * @version 1.0.0
 */
public enum ToolsTypeEnum {
    BUILTIN_TOOL(1, "builtin_tool"),
    API_TOOL(2, "api_tool"),
    ;

    private final Integer type;

    private final String name;

    ToolsTypeEnum(Integer type, String name) {
        this.type = type;
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public String getName() {
        return name;
    }
}

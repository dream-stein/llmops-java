package com.emcikem.llm.common.enums;

/**
 * Create with Emcikem on 2025/4/8
 *
 * @author Emcikem
 * @version 1.0.0
 */
public enum BuiltinToolCategoryEnum {
    NET_SEARCH(1, "网络搜索"),
    OTHER(99, "其他工具")

    ;

    private final Integer categoryId;

    private final String categoryName;

    BuiltinToolCategoryEnum(Integer categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }
}

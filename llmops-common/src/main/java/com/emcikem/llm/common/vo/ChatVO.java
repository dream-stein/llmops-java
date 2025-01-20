package com.emcikem.llm.common.vo;

import lombok.Data;

/**
 * @author wx40217
 * @date 2025/1/19
 */
@Data
public class ChatVO {
    /**
     * 租户ID
     */
    private Long tenantId;

    /**
     * 对话ID
     */
    private Long dialogId;

    /**
     * 模型名称
     */
    private String modelName;

    /**
     * 用户输入的prompt
     */
    private Long promptId;

    /**
     * 是否联网
     */
    private Boolean isOnline;

}

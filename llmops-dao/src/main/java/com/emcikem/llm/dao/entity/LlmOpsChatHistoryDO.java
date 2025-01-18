package com.emcikem.llm.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * Create with Emcikem on 2025/1/15
 *
 * @author Emcikem
 * @version 1.0.0
 */
@Data
@TableName("llmops_chat_history")
public class LlmOpsChatHistoryDO {
    private Long id;

    /**
     * 角色类型，1:assist，2:user
     */
    private Integer role;

    /**
     * 租户信息
     */
    private String tenant;

    /**
     * 对话id
     */
    private Long dialogId;

    /**
     * 对话内容
     */
    private String content;

    /**
     * token数
     */
    private Long token;

    /**
     * 创建人
     */
    private String creator;

    /**
     * 创建时间
     */
    private Date ctime;
}

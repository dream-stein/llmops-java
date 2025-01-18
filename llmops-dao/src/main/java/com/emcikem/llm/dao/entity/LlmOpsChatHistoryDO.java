package com.emcikem.llm.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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
    @TableField("id")
    @TableId(type = IdType.AUTO) // 使用数据库自增主键
    private Long id;

    /**
     * 角色类型，1:assist，2:user
     */
    @TableField("role")
    private Integer role;

    /**
     * 租户信息
     */
    @TableField("tenant")
    private String tenant;

    /**
     * 对话id
     */
    @TableField("dialog_id")
    private Long dialogId;

    /**
     * 对话内容
     */
    @TableField("content")
    private String content;

    /**
     * token数
     */
    @TableField("token")
    private Long token;

    /**
     * 创建人
     */
    @TableField("creator")
    private String creator;

    /**
     * 创建时间
     */
    @TableField("ctime")
    private Date ctime;
}

package com.emcikem.llm.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * Create with Emcikem on 2025/1/19
 *
 * @author Emcikem
 * @version 1.0.0
 */
@Data
@TableName("llmops_chat_dialog")
public class LlmOpsChatDialogDO {

    @TableField("id")
    @TableId(type = IdType.AUTO) // 使用数据库自增主键
    private Long id;

    /**
     * 对话概要
     */
    @TableField("title")
    private String title;

    /**
     * 租户信息
     */
    @TableField("tenant")
    private String tenant;

    /**
     * 对话内容
     */
    @TableField("content")
    private String content;

    /**
     * 创建人
     */
    @TableField("creator")
    private String creator;

    /**
     * 最后修改人
     */
    @TableField("operator")
    private String operator;

    /**
     * 创建时间
     */
    @TableField("ctime")
    private Date ctime;

    /**
     * 最后修改时间
     */
    @TableField("utime")
    private Date utime;
}

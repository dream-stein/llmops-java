package com.emcikem.llm.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("llmops_chat_history")
public class LlmOpsChatHistoryDO implements Serializable {

    @TableField("id")
    @TableId(type = IdType.AUTO) // 使用数据库自增主键
    private Long id;

    @TableField("role")
    private Integer role;

    @TableField("tenant_id")
    private Long tenantId;

    @TableField("token")
    private Long token;

    @TableField("creator")
    private String creator;

    @TableField("ctime")
    private Date ctime;

    @TableField("content")
    private String content;
}
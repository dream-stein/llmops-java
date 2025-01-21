package com.emcikem.llm.dao.entity;

import java.util.Date;
import lombok.Data;

/**
 * Database Table Remarks:
 *   对话记录表
 *
 * @mbg.generated do_not_delete_during_merge
 */
@Data
public class LlmOpsChatHistoryDO {
    /**
     * Database Column Remarks:
     *   聊天id
     *
     * @mbg.generated
     */
    private Long id;

    /**
     * Database Column Remarks:
     *   角色类型，1:assist，2:user
     *
     * @mbg.generated
     */
    private Integer role;

    /**
     * Database Column Remarks:
     *   租户id
     *
     * @mbg.generated
     */
    private Long tenantId;

    /**
     * Database Column Remarks:
     *   对话id
     *
     * @mbg.generated
     */
    private Long dialogId;

    /**
     * Database Column Remarks:
     *   token数
     *
     * @mbg.generated
     */
    private Long token;

    /**
     * Database Column Remarks:
     *   创建人
     *
     * @mbg.generated
     */
    private String creator;

    /**
     * Database Column Remarks:
     *   创建时间
     *
     * @mbg.generated
     */
    private Date ctime;

    /**
     * Database Column Remarks:
     *   对话内容
     *
     * @mbg.generated
     */
    private String content;
}
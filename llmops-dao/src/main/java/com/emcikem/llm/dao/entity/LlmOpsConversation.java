package com.emcikem.llm.dao.entity;

import java.util.Date;
import lombok.Data;

/**
 * Database Table Remarks:
 *   会话表
 *
 * @mbg.generated do_not_delete_during_merge
 */
@Data
public class LlmOpsConversation {
    /**
     * Database Column Remarks:
     *   主键UUID
     *
     * @mbg.generated
     */
    private String id;

    /**
     * Database Column Remarks:
     *   应用id
     *
     * @mbg.generated
     */
    private String appId;

    /**
     * Database Column Remarks:
     *   会话名称
     *
     * @mbg.generated
     */
    private String name;

    /**
     * Database Column Remarks:
     *   是否置顶
     *
     * @mbg.generated
     */
    private Boolean isPinned;

    /**
     * Database Column Remarks:
     *   是否删除
     *
     * @mbg.generated
     */
    private Boolean isDelete;

    /**
     * Database Column Remarks:
     *   来源
     *
     * @mbg.generated
     */
    private String invokeFrom;

    /**
     * Database Column Remarks:
     *   创建会话的id
     *
     * @mbg.generated
     */
    private String createdBy;

    /**
     * Database Column Remarks:
     *   创建时间
     *
     * @mbg.generated
     */
    private Date createdAt;

    /**
     * Database Column Remarks:
     *   更新时间
     *
     * @mbg.generated
     */
    private Date updatedAt;

    /**
     * Database Column Remarks:
     *   会话概要
     *
     * @mbg.generated
     */
    private String summary;
}
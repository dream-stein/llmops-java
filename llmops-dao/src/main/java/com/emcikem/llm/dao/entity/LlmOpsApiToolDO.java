package com.emcikem.llm.dao.entity;

import java.util.Date;
import lombok.Data;

/**
 * Database Table Remarks:
 *   API工具
 *
 * @mbg.generated do_not_delete_during_merge
 */
@Data
public class LlmOpsApiToolDO {
    /**
     * Database Column Remarks:
     *   主键UUID
     *
     * @mbg.generated
     */
    private String id;

    /**
     * Database Column Remarks:
     *   关联的用户id
     *
     * @mbg.generated
     */
    private String accountId;

    /**
     * Database Column Remarks:
     *   关联的提供者id
     *
     * @mbg.generated
     */
    private String providerId;

    /**
     * Database Column Remarks:
     *   工具名称
     *
     * @mbg.generated
     */
    private String name;

    /**
     * Database Column Remarks:
     *   工具API地址
     *
     * @mbg.generated
     */
    private String url;

    /**
     * Database Column Remarks:
     *   路由方法
     *
     * @mbg.generated
     */
    private String method;

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
}
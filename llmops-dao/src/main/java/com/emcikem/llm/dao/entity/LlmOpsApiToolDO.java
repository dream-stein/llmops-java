package com.emcikem.llm.dao.entity;

import java.util.Date;
import lombok.Data;

/**
 * Database Table Remarks:
 *   API工具表
 *
 * @mbg.generated do_not_delete_during_merge
 */
@Data
public class LlmOpsApiToolDO {
    /**
     * Database Column Remarks:
     *   API工具自增主键
     *
     * @mbg.generated
     */
    private Long id;

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
     *   调用方法
     *
     * @mbg.generated
     */
    private String method;

    /**
     * Database Column Remarks:
     *   最后更新时间
     *
     * @mbg.generated
     */
    private Date updatedAt;

    /**
     * Database Column Remarks:
     *   创建时间
     *
     * @mbg.generated
     */
    private Date createdAt;
}
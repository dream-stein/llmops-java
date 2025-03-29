package com.emcikem.llm.dao.entity;

import java.util.Date;
import lombok.Data;

/**
 * Database Table Remarks:
 *   知识库
 *
 * @mbg.generated do_not_delete_during_merge
 */
@Data
public class LlmOpsDatasetDO {
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
     *   知识库名称
     *
     * @mbg.generated
     */
    private String name;

    /**
     * Database Column Remarks:
     *   知识库图标
     *
     * @mbg.generated
     */
    private String icon;

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
     *   知识库描述
     *
     * @mbg.generated
     */
    private String description;
}
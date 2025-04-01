package com.emcikem.llm.dao.entity;

import java.util.Date;
import lombok.Data;

/**
 * Database Table Remarks:
 *   API工具提供者
 *
 * @mbg.generated do_not_delete_during_merge
 */
@Data
public class LlmOpsApiToolProviderDO {
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
     *   提供商名称
     *
     * @mbg.generated
     */
    private String name;

    /**
     * Database Column Remarks:
     *   提供商图标
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
}
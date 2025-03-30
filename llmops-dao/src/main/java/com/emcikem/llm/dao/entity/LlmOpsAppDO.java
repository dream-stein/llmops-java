package com.emcikem.llm.dao.entity;

import java.util.Date;
import lombok.Data;

/**
 * Database Table Remarks:
 *   AI应用表
 *
 * @mbg.generated do_not_delete_during_merge
 */
@Data
public class LlmOpsAppDO {
    /**
     * Database Column Remarks:
     *   主键UUID
     *
     * @mbg.generated
     */
    private String id;

    /**
     * Database Column Remarks:
     *   账号id
     *
     * @mbg.generated
     */
    private String accountId;

    /**
     * Database Column Remarks:
     *   已发布配置id
     *
     * @mbg.generated
     */
    private String publishedAppConfigId;

    /**
     * Database Column Remarks:
     *   调试会话id
     *
     * @mbg.generated
     */
    private String draftedAppConfigId;

    /**
     * Database Column Remarks:
     *   应用名称
     *
     * @mbg.generated
     */
    private String name;

    /**
     * Database Column Remarks:
     *   应用图标
     *
     * @mbg.generated
     */
    private String icon;

    /**
     * Database Column Remarks:
     *   应用状态
     *
     * @mbg.generated
     */
    private String status;

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
     *   应用描述
     *
     * @mbg.generated
     */
    private String description;
}
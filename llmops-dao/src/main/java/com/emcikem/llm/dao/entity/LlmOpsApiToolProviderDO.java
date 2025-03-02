package com.emcikem.llm.dao.entity;

import lombok.Data;

import java.util.Date;

/**
 * Database Table Remarks:
 *   API工具提供者表
 *
 * @mbg.generated do_not_delete_during_merge
 */
@Data
public class LlmOpsApiToolProviderDO {

    /**
     * Database Column Remarks:
     *   API工具提供者自增主键
     *
     * @mbg.generated
     */
    private Long id;

    /**
     * Database Column Remarks:
     *   工具提供商唯一标识
     *
     * @mbg.generated
     */
    private String providerId;

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
     *   提供商描述
     *
     * @mbg.generated
     */
    private String description;

    /**
     * Database Column Remarks:
     *   规范描述
     *
     * @mbg.generated
     */
    private String openapiSchema;

    /**
     * Database Column Remarks:
     *   提供商对应的请求头
     *
     * @mbg.generated
     */
    private String headers;

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
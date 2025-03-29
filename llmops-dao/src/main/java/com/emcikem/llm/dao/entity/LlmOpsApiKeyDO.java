package com.emcikem.llm.dao.entity;

import java.util.Date;
import lombok.Data;

/**
 * Database Table Remarks:
 *   API密钥表
 *
 * @mbg.generated do_not_delete_during_merge
 */
@Data
public class LlmOpsApiKeyDO {
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
     *   API密钥
     *
     * @mbg.generated
     */
    private String apiKey;

    /**
     * Database Column Remarks:
     *   是否激活
     *
     * @mbg.generated
     */
    private Integer isActive;

    /**
     * Database Column Remarks:
     *   备注信息
     *
     * @mbg.generated
     */
    private String remark;

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
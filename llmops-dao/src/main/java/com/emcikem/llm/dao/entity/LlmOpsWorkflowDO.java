package com.emcikem.llm.dao.entity;

import java.util.Date;
import lombok.Data;

/**
 * Database Table Remarks:
 *   工作流模型
 *
 * @mbg.generated do_not_delete_during_merge
 */
@Data
public class LlmOpsWorkflowDO {
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
     *   工作流名称
     *
     * @mbg.generated
     */
    private String name;

    /**
     * Database Column Remarks:
     *   工作流调用名称
     *
     * @mbg.generated
     */
    private String toolCallName;

    /**
     * Database Column Remarks:
     *   工作流图标
     *
     * @mbg.generated
     */
    private String icon;

    /**
     * Database Column Remarks:
     *   调试是否通过
     *
     * @mbg.generated
     */
    private Boolean isDebugPassed;

    /**
     * Database Column Remarks:
     *   工作流状态
     *
     * @mbg.generated
     */
    private String status;

    /**
     * Database Column Remarks:
     *   发布时间
     *
     * @mbg.generated
     */
    private Date publishedAt;

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
     *   API密钥
     *
     * @mbg.generated
     */
    private String apiKey;

    /**
     * Database Column Remarks:
     *   工作流描述
     *
     * @mbg.generated
     */
    private String description;

    /**
     * Database Column Remarks:
     *   工作流图结构信息
     *
     * @mbg.generated
     */
    private String graph;

    /**
     * Database Column Remarks:
     *   工作流草稿图
     *
     * @mbg.generated
     */
    private String draftGraph;
}
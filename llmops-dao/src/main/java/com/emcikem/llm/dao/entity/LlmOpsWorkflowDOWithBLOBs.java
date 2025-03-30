package com.emcikem.llm.dao.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Database Table Remarks:
 *   工作流模型
 *
 * @mbg.generated do_not_delete_during_merge
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class LlmOpsWorkflowDOWithBLOBs extends LlmOpsWorkflowDO {
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
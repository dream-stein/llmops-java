package com.emcikem.llm.dao.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Database Table Remarks:
 *   API工具表
 *
 * @mbg.generated do_not_delete_during_merge
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class LlmOpsApiToolDOWithBLOBs extends LlmOpsApiToolDO {
    /**
     * Database Column Remarks:
     *   工具描述
     *
     * @mbg.generated
     */
    private String description;

    /**
     * Database Column Remarks:
     *   工具参数
     *
     * @mbg.generated
     */
    private String parameters;
}
package com.emcikem.llm.dao.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Database Table Remarks:
 *   API工具提供者
 *
 * @mbg.generated do_not_delete_during_merge
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class LlmOpsApiToolProviderDOWithBLOBs extends LlmOpsApiToolProviderDO {
    /**
     * Database Column Remarks:
     *   应用描述
     *
     * @mbg.generated
     */
    private String description;

    /**
     * Database Column Remarks:
     *   描述规范
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
}
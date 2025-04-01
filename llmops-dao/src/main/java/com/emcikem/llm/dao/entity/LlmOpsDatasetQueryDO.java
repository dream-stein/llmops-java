package com.emcikem.llm.dao.entity;

import java.util.Date;
import lombok.Data;

/**
 * Database Table Remarks:
 *   知识库查询
 *
 * @mbg.generated do_not_delete_during_merge
 */
@Data
public class LlmOpsDatasetQueryDO {
    /**
     * Database Column Remarks:
     *   主键UUID
     *
     * @mbg.generated
     */
    private String id;

    /**
     * Database Column Remarks:
     *   关联的知识库id
     *
     * @mbg.generated
     */
    private String datasetId;

    /**
     * Database Column Remarks:
     *   查询的来源
     *
     * @mbg.generated
     */
    private String source;

    /**
     * Database Column Remarks:
     *   查询关联的应用id
     *
     * @mbg.generated
     */
    private String sourceAppId;

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
     *   查询query语句
     *
     * @mbg.generated
     */
    private String query;
}
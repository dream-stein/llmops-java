package com.emcikem.llm.dao.entity;

import java.util.Date;
import lombok.Data;

/**
 * Database Table Remarks:
 *   应用关联知识库表
 *
 * @mbg.generated do_not_delete_during_merge
 */
@Data
public class LlmOpsAppDatasetJoinDO {
    /**
     * Database Column Remarks:
     *   主键UUID
     *
     * @mbg.generated
     */
    private String id;

    /**
     * Database Column Remarks:
     *   关联的应用id
     *
     * @mbg.generated
     */
    private String appId;

    /**
     * Database Column Remarks:
     *   关联的知识库id
     *
     * @mbg.generated
     */
    private String datasetId;

    /**
     * Database Column Remarks:
     *   创建时间
     *
     * @mbg.generated
     */
    private Date createdAt;
}
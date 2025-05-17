package com.emcikem.llm.dao.entity;

import java.util.Date;
import lombok.Data;

/**
 * Database Table Remarks:
 *   关键词配置表
 *
 * @mbg.generated do_not_delete_during_merge
 */
@Data
public class LlmOpsKeywordTableDO {
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
     *   关键词表
     *
     * @mbg.generated
     */
    private String keywordTable;
}
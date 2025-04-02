package com.emcikem.llm.dao.entity;

import java.util.Date;
import lombok.Data;

/**
 * Database Table Remarks:
 *   文档片段
 *
 * @mbg.generated do_not_delete_during_merge
 */
@Data
public class LlmOpsSegmentDO {
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
     *   关联的知识库id
     *
     * @mbg.generated
     */
    private String datasetId;

    /**
     * Database Column Remarks:
     *   关联的文档id
     *
     * @mbg.generated
     */
    private String documentId;

    /**
     * Database Column Remarks:
     *   向量数据库节点id用于快速查找
     *
     * @mbg.generated
     */
    private String nodeId;

    /**
     * Database Column Remarks:
     *   片段在文档的位置
     *
     * @mbg.generated
     */
    private Integer position;

    /**
     * Database Column Remarks:
     *   片段长度
     *
     * @mbg.generated
     */
    private Integer characterCount;

    /**
     * Database Column Remarks:
     *   token词数
     *
     * @mbg.generated
     */
    private Integer tokenCount;

    /**
     * Database Column Remarks:
     *   内容哈希值
     *
     * @mbg.generated
     */
    private String hash;

    /**
     * Database Column Remarks:
     *   命中次数
     *
     * @mbg.generated
     */
    private Integer hitCount;

    /**
     * Database Column Remarks:
     *   是否启用
     *
     * @mbg.generated
     */
    private Boolean enabled;

    /**
     * Database Column Remarks:
     *   禁用时间
     *
     * @mbg.generated
     */
    private Date disabledAt;

    /**
     * Database Column Remarks:
     *   开始处理时间
     *
     * @mbg.generated
     */
    private Date processingStartedAt;

    /**
     * Database Column Remarks:
     *   索引结束时间
     *
     * @mbg.generated
     */
    private Date indexCompletedAt;

    /**
     * Database Column Remarks:
     *   构建完成时间
     *
     * @mbg.generated
     */
    private Date completedAt;

    /**
     * Database Column Remarks:
     *   停止时间
     *
     * @mbg.generated
     */
    private Date stoppedAt;

    /**
     * Database Column Remarks:
     *   状态（如 waiting/processing/completed）
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
     *   片段内容
     *
     * @mbg.generated
     */
    private String content;

    /**
     * Database Column Remarks:
     *   关键词列表
     *
     * @mbg.generated
     */
    private String keywords;

    /**
     * Database Column Remarks:
     *   错误日志
     *
     * @mbg.generated
     */
    private String error;
}
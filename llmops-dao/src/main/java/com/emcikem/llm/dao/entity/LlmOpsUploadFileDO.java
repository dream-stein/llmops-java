package com.emcikem.llm.dao.entity;

import java.util.Date;
import lombok.Data;

/**
 * Database Table Remarks:
 *   上传文件
 *
 * @mbg.generated do_not_delete_during_merge
 */
@Data
public class LlmOpsUploadFileDO {
    /**
     * Database Column Remarks:
     *   主键UUID
     *
     * @mbg.generated
     */
    private String id;

    /**
     * Database Column Remarks:
     *   上传文件的用户id
     *
     * @mbg.generated
     */
    private String accountId;

    /**
     * Database Column Remarks:
     *   上传的文件名
     *
     * @mbg.generated
     */
    private String name;

    /**
     * Database Column Remarks:
     *   对象存储文件路径
     *
     * @mbg.generated
     */
    private String key;

    /**
     * Database Column Remarks:
     *   上传文件的大小
     *
     * @mbg.generated
     */
    private Integer size;

    /**
     * Database Column Remarks:
     *   文件扩展名
     *
     * @mbg.generated
     */
    private String extension;

    /**
     * Database Column Remarks:
     *   mimetype
     *
     * @mbg.generated
     */
    private String mimeType;

    /**
     * Database Column Remarks:
     *   文件内容的哈希值
     *
     * @mbg.generated
     */
    private String hash;

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
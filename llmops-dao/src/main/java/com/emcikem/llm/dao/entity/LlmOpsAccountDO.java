package com.emcikem.llm.dao.entity;

import java.util.Date;
import lombok.Data;

/**
 * Database Table Remarks:
 *   账号表
 *
 * @mbg.generated do_not_delete_during_merge
 */
@Data
public class LlmOpsAccountDO {
    /**
     * Database Column Remarks:
     *   主键UUID
     *
     * @mbg.generated
     */
    private String id;

    /**
     * Database Column Remarks:
     *   账号名称
     *
     * @mbg.generated
     */
    private String name;

    /**
     * Database Column Remarks:
     *   绑定邮箱
     *
     * @mbg.generated
     */
    private String email;

    /**
     * Database Column Remarks:
     *   密码
     *
     * @mbg.generated
     */
    private String password;

    /**
     * Database Column Remarks:
     *   密码盐值
     *
     * @mbg.generated
     */
    private String passwordSalt;

    /**
     * Database Column Remarks:
     *   最后登录时间
     *
     * @mbg.generated
     */
    private Date lastLoginAt;

    /**
     * Database Column Remarks:
     *   最后登录ip
     *
     * @mbg.generated
     */
    private String lastLoginIp;

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
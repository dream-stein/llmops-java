package com.emcikem.llm.dao.entity;

import java.util.Date;
import lombok.Data;

/**
 * Database Table Remarks:
 *   对话概要表
 *
 * @mbg.generated do_not_delete_during_merge
 */
@Data
public class LlmOpsChatDialogDO {
    /**
     * Database Column Remarks:
     *   兑换id
     *
     * @mbg.generated
     */
    private Long id;

    /**
     * Database Column Remarks:
     *   对话概要
     *
     * @mbg.generated
     */
    private String title;

    /**
     * Database Column Remarks:
     *   租户id
     *
     * @mbg.generated
     */
    private Long tenantId;

    /**
     * Database Column Remarks:
     *   创建人
     *
     * @mbg.generated
     */
    private String creator;

    /**
     * Database Column Remarks:
     *   最后修改人
     *
     * @mbg.generated
     */
    private String operator;

    /**
     * Database Column Remarks:
     *   创建时间
     *
     * @mbg.generated
     */
    private Date ctime;

    /**
     * Database Column Remarks:
     *   最后修改时间
     *
     * @mbg.generated
     */
    private Date utime;

    /**
     * Database Column Remarks:
     *   对话内容
     *
     * @mbg.generated
     */
    private String content;
}
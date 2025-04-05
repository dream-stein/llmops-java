package com.emcikem.llm.dao.entity;

import java.util.Date;
import lombok.Data;

/**
 * Database Table Remarks:
 *   消息表
 *
 * @mbg.generated do_not_delete_during_merge
 */
@Data
public class LlmOpsMessage {
    /**
     * Database Column Remarks:
     *   主键UUID
     *
     * @mbg.generated
     */
    private String id;

    /**
     * Database Column Remarks:
     *   应用id
     *
     * @mbg.generated
     */
    private String appId;

    /**
     * Database Column Remarks:
     *   会话id
     *
     * @mbg.generated
     */
    private String conversation;

    /**
     * Database Column Remarks:
     *   调用来源
     *
     * @mbg.generated
     */
    private String invokeFrom;

    /**
     * Database Column Remarks:
     *   创建账号id
     *
     * @mbg.generated
     */
    private String createdBy;

    /**
     * Database Column Remarks:
     *   token数
     *
     * @mbg.generated
     */
    private Integer messageTokenCount;

    /**
     * Database Column Remarks:
     *   单价
     *
     * @mbg.generated
     */
    private Float messageUnitPrice;

    /**
     * Database Column Remarks:
     *   价格单位
     *
     * @mbg.generated
     */
    private Float messagePriceUnit;

    /**
     * Database Column Remarks:
     *   token数
     *
     * @mbg.generated
     */
    private Integer answerTokenCount;

    /**
     * Database Column Remarks:
     *   单价
     *
     * @mbg.generated
     */
    private Float answerUnitPrice;

    /**
     * Database Column Remarks:
     *   价格单位
     *
     * @mbg.generated
     */
    private Float answerPriceUnit;

    /**
     * Database Column Remarks:
     *   响应耗时
     *
     * @mbg.generated
     */
    private Float latency;

    /**
     * Database Column Remarks:
     *   总token数
     *
     * @mbg.generated
     */
    private Integer totalTokenCount;

    /**
     * Database Column Remarks:
     *   消息总价格
     *
     * @mbg.generated
     */
    private Float totalPrice;

    /**
     * Database Column Remarks:
     *   状态
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
     *   消息的原始问题
     *
     * @mbg.generated
     */
    private String query;

    /**
     * Database Column Remarks:
     *   最终消息列表
     *
     * @mbg.generated
     */
    private String message;

    /**
     * Database Column Remarks:
     *   AI内容消息
     *
     * @mbg.generated
     */
    private String answer;

    /**
     * Database Column Remarks:
     *   错误日志
     *
     * @mbg.generated
     */
    private String error;
}
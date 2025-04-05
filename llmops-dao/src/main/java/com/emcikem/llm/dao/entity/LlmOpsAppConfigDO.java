package com.emcikem.llm.dao.entity;

import java.util.Date;
import lombok.Data;

/**
 * Database Table Remarks:
 *   应用配置表
 *
 * @mbg.generated do_not_delete_during_merge
 */
@Data
public class LlmOpsAppConfigDO {
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
     *   上下文对话轮数
     *
     * @mbg.generated
     */
    private Integer dialogRound;

    /**
     * Database Column Remarks:
     *   对话开场白
     *
     * @mbg.generated
     */
    private String openingStatement;

    /**
     * Database Column Remarks:
     *   配置类型
     *
     * @mbg.generated
     */
    private Boolean configType;

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
     *   模型配置
     *
     * @mbg.generated
     */
    private String modelConfig;

    /**
     * Database Column Remarks:
     *   人设与回复逻辑
     *
     * @mbg.generated
     */
    private String presetPrompt;

    /**
     * Database Column Remarks:
     *   关联工具列表
     *
     * @mbg.generated
     */
    private String tools;

    /**
     * Database Column Remarks:
     *   关联工作流列表
     *
     * @mbg.generated
     */
    private String workflows;

    /**
     * Database Column Remarks:
     *   知识库检索配置
     *
     * @mbg.generated
     */
    private String retrievalConfig;

    /**
     * Database Column Remarks:
     *   长期记忆配置
     *
     * @mbg.generated
     */
    private String longTermMemory;

    /**
     * Database Column Remarks:
     *   开场建议问题
     *
     * @mbg.generated
     */
    private String openingQuestions;

    /**
     * Database Column Remarks:
     *   回答后建议问题
     *
     * @mbg.generated
     */
    private String suggestedAfterAnswer;

    /**
     * Database Column Remarks:
     *   语音转文本配置
     *
     * @mbg.generated
     */
    private String speechToText;

    /**
     * Database Column Remarks:
     *   文本转语音配置
     *
     * @mbg.generated
     */
    private String textToSpeech;

    /**
     * Database Column Remarks:
     *   内容审核配置
     *
     * @mbg.generated
     */
    private String reviewConfig;
}
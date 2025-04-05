package com.emcikem.llm.dao.mapper;

import com.emcikem.llm.dao.entity.LlmOpsConversation;
import com.emcikem.llm.dao.example.LlmOpsConversationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LlmOpsConversationMapper {
    /**
     *
     * @mbg.generated
     */
    long countByExample(LlmOpsConversationExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByExample(LlmOpsConversationExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbg.generated
     */
    int insert(LlmOpsConversation record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(LlmOpsConversation record);

    /**
     *
     * @mbg.generated
     */
    List<LlmOpsConversation> selectByExampleWithBLOBs(LlmOpsConversationExample example);

    /**
     *
     * @mbg.generated
     */
    List<LlmOpsConversation> selectByExample(LlmOpsConversationExample example);

    /**
     *
     * @mbg.generated
     */
    LlmOpsConversation selectByPrimaryKey(String id);

    /**
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") LlmOpsConversation record, @Param("example") LlmOpsConversationExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExampleWithBLOBs(@Param("record") LlmOpsConversation record, @Param("example") LlmOpsConversationExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") LlmOpsConversation record, @Param("example") LlmOpsConversationExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(LlmOpsConversation record);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeyWithBLOBs(LlmOpsConversation record);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(LlmOpsConversation record);
}
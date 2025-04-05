package com.emcikem.llm.dao.mapper;

import com.emcikem.llm.dao.entity.LlmOpsConversationDO;
import com.emcikem.llm.dao.example.LlmOpsConversationDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LlmOpsConversationDOMapper {
    /**
     *
     * @mbg.generated
     */
    long countByExample(LlmOpsConversationDOExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByExample(LlmOpsConversationDOExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbg.generated
     */
    int insert(LlmOpsConversationDO record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(LlmOpsConversationDO record);

    /**
     *
     * @mbg.generated
     */
    List<LlmOpsConversationDO> selectByExampleWithBLOBs(LlmOpsConversationDOExample example);

    /**
     *
     * @mbg.generated
     */
    List<LlmOpsConversationDO> selectByExample(LlmOpsConversationDOExample example);

    /**
     *
     * @mbg.generated
     */
    LlmOpsConversationDO selectByPrimaryKey(String id);

    /**
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") LlmOpsConversationDO record, @Param("example") LlmOpsConversationDOExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExampleWithBLOBs(@Param("record") LlmOpsConversationDO record, @Param("example") LlmOpsConversationDOExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") LlmOpsConversationDO record, @Param("example") LlmOpsConversationDOExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(LlmOpsConversationDO record);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeyWithBLOBs(LlmOpsConversationDO record);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(LlmOpsConversationDO record);
}
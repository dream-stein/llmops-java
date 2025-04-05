package com.emcikem.llm.dao.mapper;

import com.emcikem.llm.dao.entity.LlmOpsMessage;
import com.emcikem.llm.dao.example.LlmOpsMessageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LlmOpsMessageMapper {
    /**
     *
     * @mbg.generated
     */
    long countByExample(LlmOpsMessageExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByExample(LlmOpsMessageExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbg.generated
     */
    int insert(LlmOpsMessage record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(LlmOpsMessage record);

    /**
     *
     * @mbg.generated
     */
    List<LlmOpsMessage> selectByExampleWithBLOBs(LlmOpsMessageExample example);

    /**
     *
     * @mbg.generated
     */
    List<LlmOpsMessage> selectByExample(LlmOpsMessageExample example);

    /**
     *
     * @mbg.generated
     */
    LlmOpsMessage selectByPrimaryKey(String id);

    /**
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") LlmOpsMessage record, @Param("example") LlmOpsMessageExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExampleWithBLOBs(@Param("record") LlmOpsMessage record, @Param("example") LlmOpsMessageExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") LlmOpsMessage record, @Param("example") LlmOpsMessageExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(LlmOpsMessage record);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeyWithBLOBs(LlmOpsMessage record);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(LlmOpsMessage record);
}
package com.emcikem.llm.dao.mapper;

import com.emcikem.llm.dao.entity.LlmOpsMessageDO;
import com.emcikem.llm.dao.example.LlmOpsMessageDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LlmOpsMessageDOMapper {
    /**
     *
     * @mbg.generated
     */
    long countByExample(LlmOpsMessageDOExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByExample(LlmOpsMessageDOExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbg.generated
     */
    int insert(LlmOpsMessageDO record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(LlmOpsMessageDO record);

    /**
     *
     * @mbg.generated
     */
    List<LlmOpsMessageDO> selectByExampleWithBLOBs(LlmOpsMessageDOExample example);

    /**
     *
     * @mbg.generated
     */
    List<LlmOpsMessageDO> selectByExample(LlmOpsMessageDOExample example);

    /**
     *
     * @mbg.generated
     */
    LlmOpsMessageDO selectByPrimaryKey(String id);

    /**
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") LlmOpsMessageDO record, @Param("example") LlmOpsMessageDOExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExampleWithBLOBs(@Param("record") LlmOpsMessageDO record, @Param("example") LlmOpsMessageDOExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") LlmOpsMessageDO record, @Param("example") LlmOpsMessageDOExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(LlmOpsMessageDO record);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeyWithBLOBs(LlmOpsMessageDO record);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(LlmOpsMessageDO record);
}
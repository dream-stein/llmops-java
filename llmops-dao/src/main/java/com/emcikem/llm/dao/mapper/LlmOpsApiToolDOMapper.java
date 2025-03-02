package com.emcikem.llm.dao.mapper;

import com.emcikem.llm.dao.entity.LlmOpsApiToolDO;
import com.emcikem.llm.dao.example.LlmOpsApiToolDOExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LlmOpsApiToolDOMapper {
    /**
     *
     * @mbg.generated
     */
    long countByExample(LlmOpsApiToolDOExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByExample(LlmOpsApiToolDOExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated
     */
    int insert(LlmOpsApiToolDO record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(LlmOpsApiToolDO record);

    /**
     *
     * @mbg.generated
     */
    List<LlmOpsApiToolDO> selectByExampleWithBLOBs(LlmOpsApiToolDOExample example);

    /**
     *
     * @mbg.generated
     */
    List<LlmOpsApiToolDO> selectByExample(LlmOpsApiToolDOExample example);

    /**
     *
     * @mbg.generated
     */
    LlmOpsApiToolDO selectByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") LlmOpsApiToolDO record, @Param("example") LlmOpsApiToolDOExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExampleWithBLOBs(@Param("record") LlmOpsApiToolDO record, @Param("example") LlmOpsApiToolDOExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") LlmOpsApiToolDO record, @Param("example") LlmOpsApiToolDOExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(LlmOpsApiToolDO record);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeyWithBLOBs(LlmOpsApiToolDO record);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(LlmOpsApiToolDO record);
}
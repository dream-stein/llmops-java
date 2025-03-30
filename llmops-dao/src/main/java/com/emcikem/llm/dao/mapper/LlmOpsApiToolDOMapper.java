package com.emcikem.llm.dao.mapper;

import com.emcikem.llm.dao.entity.LlmOpsApiToolDO;
import com.emcikem.llm.dao.entity.LlmOpsApiToolDOWithBLOBs;
import com.emcikem.llm.dao.example.LlmOpsApiToolDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

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
    int insert(LlmOpsApiToolDOWithBLOBs record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(LlmOpsApiToolDOWithBLOBs record);

    /**
     *
     * @mbg.generated
     */
    List<LlmOpsApiToolDOWithBLOBs> selectByExampleWithBLOBs(LlmOpsApiToolDOExample example);

    /**
     *
     * @mbg.generated
     */
    List<LlmOpsApiToolDO> selectByExample(LlmOpsApiToolDOExample example);

    /**
     *
     * @mbg.generated
     */
    LlmOpsApiToolDOWithBLOBs selectByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") LlmOpsApiToolDOWithBLOBs record, @Param("example") LlmOpsApiToolDOExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExampleWithBLOBs(@Param("record") LlmOpsApiToolDOWithBLOBs record, @Param("example") LlmOpsApiToolDOExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") LlmOpsApiToolDO record, @Param("example") LlmOpsApiToolDOExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(LlmOpsApiToolDOWithBLOBs record);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeyWithBLOBs(LlmOpsApiToolDOWithBLOBs record);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(LlmOpsApiToolDO record);
}
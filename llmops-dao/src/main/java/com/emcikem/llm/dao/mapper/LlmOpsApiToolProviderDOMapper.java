package com.emcikem.llm.dao.mapper;

import com.emcikem.llm.dao.entity.LlmOpsApiToolProviderDO;
import com.emcikem.llm.dao.entity.LlmOpsApiToolProviderDOWithBLOBs;
import com.emcikem.llm.dao.example.LlmOpsApiToolProviderDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LlmOpsApiToolProviderDOMapper {
    /**
     *
     * @mbg.generated
     */
    long countByExample(LlmOpsApiToolProviderDOExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByExample(LlmOpsApiToolProviderDOExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated
     */
    int insert(LlmOpsApiToolProviderDOWithBLOBs record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(LlmOpsApiToolProviderDOWithBLOBs record);

    /**
     *
     * @mbg.generated
     */
    List<LlmOpsApiToolProviderDOWithBLOBs> selectByExampleWithBLOBs(LlmOpsApiToolProviderDOExample example);

    /**
     *
     * @mbg.generated
     */
    List<LlmOpsApiToolProviderDO> selectByExample(LlmOpsApiToolProviderDOExample example);

    /**
     *
     * @mbg.generated
     */
    LlmOpsApiToolProviderDOWithBLOBs selectByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") LlmOpsApiToolProviderDOWithBLOBs record, @Param("example") LlmOpsApiToolProviderDOExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExampleWithBLOBs(@Param("record") LlmOpsApiToolProviderDOWithBLOBs record, @Param("example") LlmOpsApiToolProviderDOExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") LlmOpsApiToolProviderDO record, @Param("example") LlmOpsApiToolProviderDOExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(LlmOpsApiToolProviderDOWithBLOBs record);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeyWithBLOBs(LlmOpsApiToolProviderDOWithBLOBs record);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(LlmOpsApiToolProviderDO record);
}
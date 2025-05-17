package com.emcikem.llm.dao.mapper;

import com.emcikem.llm.dao.entity.LlmOpsProcessRuleDO;
import com.emcikem.llm.dao.example.LlmOpsProcessRuleDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LlmOpsProcessRuleDOMapper {
    /**
     *
     * @mbg.generated
     */
    long countByExample(LlmOpsProcessRuleDOExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByExample(LlmOpsProcessRuleDOExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbg.generated
     */
    int insert(LlmOpsProcessRuleDO record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(LlmOpsProcessRuleDO record);

    /**
     *
     * @mbg.generated
     */
    List<LlmOpsProcessRuleDO> selectByExampleWithBLOBs(LlmOpsProcessRuleDOExample example);

    /**
     *
     * @mbg.generated
     */
    List<LlmOpsProcessRuleDO> selectByExample(LlmOpsProcessRuleDOExample example);

    /**
     *
     * @mbg.generated
     */
    LlmOpsProcessRuleDO selectByPrimaryKey(String id);

    /**
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") LlmOpsProcessRuleDO record, @Param("example") LlmOpsProcessRuleDOExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExampleWithBLOBs(@Param("record") LlmOpsProcessRuleDO record, @Param("example") LlmOpsProcessRuleDOExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") LlmOpsProcessRuleDO record, @Param("example") LlmOpsProcessRuleDOExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(LlmOpsProcessRuleDO record);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeyWithBLOBs(LlmOpsProcessRuleDO record);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(LlmOpsProcessRuleDO record);
}
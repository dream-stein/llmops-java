package com.emcikem.llm.dao.mapper;

import com.emcikem.llm.dao.entity.LlmOpsWorkflowDO;
import com.emcikem.llm.dao.entity.LlmOpsWorkflowDOWithBLOBs;
import com.emcikem.llm.dao.example.LlmOpsWorkflowDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LlmOpsWorkflowDOMapper {
    /**
     *
     * @mbg.generated
     */
    long countByExample(LlmOpsWorkflowDOExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByExample(LlmOpsWorkflowDOExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbg.generated
     */
    int insert(LlmOpsWorkflowDOWithBLOBs record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(LlmOpsWorkflowDOWithBLOBs record);

    /**
     *
     * @mbg.generated
     */
    List<LlmOpsWorkflowDOWithBLOBs> selectByExampleWithBLOBs(LlmOpsWorkflowDOExample example);

    /**
     *
     * @mbg.generated
     */
    List<LlmOpsWorkflowDO> selectByExample(LlmOpsWorkflowDOExample example);

    /**
     *
     * @mbg.generated
     */
    LlmOpsWorkflowDOWithBLOBs selectByPrimaryKey(String id);

    /**
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") LlmOpsWorkflowDOWithBLOBs record, @Param("example") LlmOpsWorkflowDOExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExampleWithBLOBs(@Param("record") LlmOpsWorkflowDOWithBLOBs record, @Param("example") LlmOpsWorkflowDOExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") LlmOpsWorkflowDO record, @Param("example") LlmOpsWorkflowDOExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(LlmOpsWorkflowDOWithBLOBs record);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeyWithBLOBs(LlmOpsWorkflowDOWithBLOBs record);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(LlmOpsWorkflowDO record);
}
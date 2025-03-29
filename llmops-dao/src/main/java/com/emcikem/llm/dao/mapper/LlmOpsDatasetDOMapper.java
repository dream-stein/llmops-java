package com.emcikem.llm.dao.mapper;

import com.emcikem.llm.dao.entity.LlmOpsDatasetDO;
import com.emcikem.llm.dao.example.LlmOpsDatasetDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LlmOpsDatasetDOMapper {
    /**
     *
     * @mbg.generated
     */
    long countByExample(LlmOpsDatasetDOExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByExample(LlmOpsDatasetDOExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbg.generated
     */
    int insert(LlmOpsDatasetDO record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(LlmOpsDatasetDO record);

    /**
     *
     * @mbg.generated
     */
    List<LlmOpsDatasetDO> selectByExampleWithBLOBs(LlmOpsDatasetDOExample example);

    /**
     *
     * @mbg.generated
     */
    List<LlmOpsDatasetDO> selectByExample(LlmOpsDatasetDOExample example);

    /**
     *
     * @mbg.generated
     */
    LlmOpsDatasetDO selectByPrimaryKey(String id);

    /**
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") LlmOpsDatasetDO record, @Param("example") LlmOpsDatasetDOExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExampleWithBLOBs(@Param("record") LlmOpsDatasetDO record, @Param("example") LlmOpsDatasetDOExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") LlmOpsDatasetDO record, @Param("example") LlmOpsDatasetDOExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(LlmOpsDatasetDO record);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeyWithBLOBs(LlmOpsDatasetDO record);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(LlmOpsDatasetDO record);
}
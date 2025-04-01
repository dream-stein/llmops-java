package com.emcikem.llm.dao.mapper;

import com.emcikem.llm.dao.entity.LlmOpsDatasetQueryDO;
import com.emcikem.llm.dao.example.LlmOpsDatasetQueryDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LlmOpsDatasetQueryDOMapper {
    /**
     *
     * @mbg.generated
     */
    long countByExample(LlmOpsDatasetQueryDOExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByExample(LlmOpsDatasetQueryDOExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbg.generated
     */
    int insert(LlmOpsDatasetQueryDO record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(LlmOpsDatasetQueryDO record);

    /**
     *
     * @mbg.generated
     */
    List<LlmOpsDatasetQueryDO> selectByExampleWithBLOBs(LlmOpsDatasetQueryDOExample example);

    /**
     *
     * @mbg.generated
     */
    List<LlmOpsDatasetQueryDO> selectByExample(LlmOpsDatasetQueryDOExample example);

    /**
     *
     * @mbg.generated
     */
    LlmOpsDatasetQueryDO selectByPrimaryKey(String id);

    /**
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") LlmOpsDatasetQueryDO record, @Param("example") LlmOpsDatasetQueryDOExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExampleWithBLOBs(@Param("record") LlmOpsDatasetQueryDO record, @Param("example") LlmOpsDatasetQueryDOExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") LlmOpsDatasetQueryDO record, @Param("example") LlmOpsDatasetQueryDOExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(LlmOpsDatasetQueryDO record);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeyWithBLOBs(LlmOpsDatasetQueryDO record);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(LlmOpsDatasetQueryDO record);
}
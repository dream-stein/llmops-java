package com.emcikem.llm.dao.mapper;

import com.emcikem.llm.dao.entity.LlmOpsSegmentDO;
import com.emcikem.llm.dao.example.LlmOpsSegmentDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LlmOpsSegmentDOMapper {
    /**
     *
     * @mbg.generated
     */
    long countByExample(LlmOpsSegmentDOExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByExample(LlmOpsSegmentDOExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbg.generated
     */
    int insert(LlmOpsSegmentDO record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(LlmOpsSegmentDO record);

    /**
     *
     * @mbg.generated
     */
    List<LlmOpsSegmentDO> selectByExampleWithBLOBs(LlmOpsSegmentDOExample example);

    /**
     *
     * @mbg.generated
     */
    List<LlmOpsSegmentDO> selectByExample(LlmOpsSegmentDOExample example);

    /**
     *
     * @mbg.generated
     */
    LlmOpsSegmentDO selectByPrimaryKey(String id);

    /**
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") LlmOpsSegmentDO record, @Param("example") LlmOpsSegmentDOExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExampleWithBLOBs(@Param("record") LlmOpsSegmentDO record, @Param("example") LlmOpsSegmentDOExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") LlmOpsSegmentDO record, @Param("example") LlmOpsSegmentDOExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(LlmOpsSegmentDO record);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeyWithBLOBs(LlmOpsSegmentDO record);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(LlmOpsSegmentDO record);
}
package com.emcikem.llm.dao.mapper;

import com.emcikem.llm.dao.entity.LlmOpsAppDatasetJoinDO;
import com.emcikem.llm.dao.example.LlmOpsAppDatasetJoinDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LlmOpsAppDatasetJoinDOMapper {
    /**
     *
     * @mbg.generated
     */
    long countByExample(LlmOpsAppDatasetJoinDOExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByExample(LlmOpsAppDatasetJoinDOExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbg.generated
     */
    int insert(LlmOpsAppDatasetJoinDO record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(LlmOpsAppDatasetJoinDO record);

    /**
     *
     * @mbg.generated
     */
    List<LlmOpsAppDatasetJoinDO> selectByExample(LlmOpsAppDatasetJoinDOExample example);

    /**
     *
     * @mbg.generated
     */
    LlmOpsAppDatasetJoinDO selectByPrimaryKey(String id);

    /**
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") LlmOpsAppDatasetJoinDO record, @Param("example") LlmOpsAppDatasetJoinDOExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") LlmOpsAppDatasetJoinDO record, @Param("example") LlmOpsAppDatasetJoinDOExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(LlmOpsAppDatasetJoinDO record);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(LlmOpsAppDatasetJoinDO record);
}
package com.emcikem.llm.dao.mapper;

import com.emcikem.llm.dao.entity.LlmOpsAppConfigDO;
import com.emcikem.llm.dao.example.LlmOpsAppConfigDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LlmOpsAppConfigDOMapper {
    /**
     *
     * @mbg.generated
     */
    long countByExample(LlmOpsAppConfigDOExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByExample(LlmOpsAppConfigDOExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbg.generated
     */
    int insert(LlmOpsAppConfigDO record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(LlmOpsAppConfigDO record);

    /**
     *
     * @mbg.generated
     */
    List<LlmOpsAppConfigDO> selectByExampleWithBLOBs(LlmOpsAppConfigDOExample example);

    /**
     *
     * @mbg.generated
     */
    List<LlmOpsAppConfigDO> selectByExample(LlmOpsAppConfigDOExample example);

    /**
     *
     * @mbg.generated
     */
    LlmOpsAppConfigDO selectByPrimaryKey(String id);

    /**
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") LlmOpsAppConfigDO record, @Param("example") LlmOpsAppConfigDOExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExampleWithBLOBs(@Param("record") LlmOpsAppConfigDO record, @Param("example") LlmOpsAppConfigDOExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") LlmOpsAppConfigDO record, @Param("example") LlmOpsAppConfigDOExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(LlmOpsAppConfigDO record);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeyWithBLOBs(LlmOpsAppConfigDO record);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(LlmOpsAppConfigDO record);
}
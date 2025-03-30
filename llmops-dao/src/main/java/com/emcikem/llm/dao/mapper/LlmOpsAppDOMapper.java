package com.emcikem.llm.dao.mapper;

import com.emcikem.llm.dao.entity.LlmOpsAppDO;
import com.emcikem.llm.dao.example.LlmOpsAppDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LlmOpsAppDOMapper {
    /**
     *
     * @mbg.generated
     */
    long countByExample(LlmOpsAppDOExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByExample(LlmOpsAppDOExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbg.generated
     */
    int insert(LlmOpsAppDO record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(LlmOpsAppDO record);

    /**
     *
     * @mbg.generated
     */
    List<LlmOpsAppDO> selectByExampleWithBLOBs(LlmOpsAppDOExample example);

    /**
     *
     * @mbg.generated
     */
    List<LlmOpsAppDO> selectByExample(LlmOpsAppDOExample example);

    /**
     *
     * @mbg.generated
     */
    LlmOpsAppDO selectByPrimaryKey(String id);

    /**
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") LlmOpsAppDO record, @Param("example") LlmOpsAppDOExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExampleWithBLOBs(@Param("record") LlmOpsAppDO record, @Param("example") LlmOpsAppDOExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") LlmOpsAppDO record, @Param("example") LlmOpsAppDOExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(LlmOpsAppDO record);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeyWithBLOBs(LlmOpsAppDO record);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(LlmOpsAppDO record);
}
package com.emcikem.llm.dao.mapper;

import com.emcikem.llm.dao.entity.LlmOpsKeywordTableDO;
import com.emcikem.llm.dao.example.LlmOpsKeywordTableDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LlmOpsKeywordTableDOMapper {
    /**
     *
     * @mbg.generated
     */
    long countByExample(LlmOpsKeywordTableDOExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByExample(LlmOpsKeywordTableDOExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbg.generated
     */
    int insert(LlmOpsKeywordTableDO record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(LlmOpsKeywordTableDO record);

    /**
     *
     * @mbg.generated
     */
    List<LlmOpsKeywordTableDO> selectByExampleWithBLOBs(LlmOpsKeywordTableDOExample example);

    /**
     *
     * @mbg.generated
     */
    List<LlmOpsKeywordTableDO> selectByExample(LlmOpsKeywordTableDOExample example);

    /**
     *
     * @mbg.generated
     */
    LlmOpsKeywordTableDO selectByPrimaryKey(String id);

    /**
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") LlmOpsKeywordTableDO record, @Param("example") LlmOpsKeywordTableDOExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExampleWithBLOBs(@Param("record") LlmOpsKeywordTableDO record, @Param("example") LlmOpsKeywordTableDOExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") LlmOpsKeywordTableDO record, @Param("example") LlmOpsKeywordTableDOExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(LlmOpsKeywordTableDO record);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeyWithBLOBs(LlmOpsKeywordTableDO record);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(LlmOpsKeywordTableDO record);
}
package com.emcikem.llm.dao.mapper;

import com.emcikem.llm.dao.entity.LlmOpsDocumentDO;
import com.emcikem.llm.dao.example.LlmOpsDocumentDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LlmOpsDocumentDOMapper {
    /**
     *
     * @mbg.generated
     */
    long countByExample(LlmOpsDocumentDOExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByExample(LlmOpsDocumentDOExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbg.generated
     */
    int insert(LlmOpsDocumentDO record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(LlmOpsDocumentDO record);

    /**
     *
     * @mbg.generated
     */
    List<LlmOpsDocumentDO> selectByExampleWithBLOBs(LlmOpsDocumentDOExample example);

    /**
     *
     * @mbg.generated
     */
    List<LlmOpsDocumentDO> selectByExample(LlmOpsDocumentDOExample example);

    /**
     *
     * @mbg.generated
     */
    LlmOpsDocumentDO selectByPrimaryKey(String id);

    /**
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") LlmOpsDocumentDO record, @Param("example") LlmOpsDocumentDOExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExampleWithBLOBs(@Param("record") LlmOpsDocumentDO record, @Param("example") LlmOpsDocumentDOExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") LlmOpsDocumentDO record, @Param("example") LlmOpsDocumentDOExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(LlmOpsDocumentDO record);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeyWithBLOBs(LlmOpsDocumentDO record);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(LlmOpsDocumentDO record);
}
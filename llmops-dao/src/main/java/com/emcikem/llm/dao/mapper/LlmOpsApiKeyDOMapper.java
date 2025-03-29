package com.emcikem.llm.dao.mapper;

import com.emcikem.llm.dao.entity.LlmOpsApiKeyDO;
import com.emcikem.llm.dao.example.LlmOpsApiKeyDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LlmOpsApiKeyDOMapper {
    /**
     *
     * @mbg.generated
     */
    long countByExample(LlmOpsApiKeyDOExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByExample(LlmOpsApiKeyDOExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbg.generated
     */
    int insert(LlmOpsApiKeyDO record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(LlmOpsApiKeyDO record);

    /**
     *
     * @mbg.generated
     */
    List<LlmOpsApiKeyDO> selectByExample(LlmOpsApiKeyDOExample example);

    /**
     *
     * @mbg.generated
     */
    LlmOpsApiKeyDO selectByPrimaryKey(String id);

    /**
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") LlmOpsApiKeyDO record, @Param("example") LlmOpsApiKeyDOExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") LlmOpsApiKeyDO record, @Param("example") LlmOpsApiKeyDOExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(LlmOpsApiKeyDO record);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(LlmOpsApiKeyDO record);
}
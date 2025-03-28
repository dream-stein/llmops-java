package com.emcikem.llm.dao.mapper;

import com.emcikem.llm.dao.entity.LlmOpsAccountDO;
import com.emcikem.llm.dao.example.LlmOpsAccountDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LlmOpsAccountDOMapper {
    /**
     *
     * @mbg.generated
     */
    long countByExample(LlmOpsAccountDOExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByExample(LlmOpsAccountDOExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbg.generated
     */
    int insert(LlmOpsAccountDO record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(LlmOpsAccountDO record);

    /**
     *
     * @mbg.generated
     */
    List<LlmOpsAccountDO> selectByExample(LlmOpsAccountDOExample example);

    /**
     *
     * @mbg.generated
     */
    LlmOpsAccountDO selectByPrimaryKey(String id);

    /**
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") LlmOpsAccountDO record, @Param("example") LlmOpsAccountDOExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") LlmOpsAccountDO record, @Param("example") LlmOpsAccountDOExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(LlmOpsAccountDO record);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(LlmOpsAccountDO record);
}
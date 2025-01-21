package com.emcikem.llm.dao.mapper;

import com.emcikem.llm.dao.entity.LlmOpsChatHistoryDO;
import com.emcikem.llm.dao.example.LlmOpsChatHistoryDOExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LlmOpsChatHistoryDOMapper {
    /**
     *
     * @mbg.generated
     */
    long countByExample(LlmOpsChatHistoryDOExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByExample(LlmOpsChatHistoryDOExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated
     */
    int insert(LlmOpsChatHistoryDO record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(LlmOpsChatHistoryDO record);

    /**
     *
     * @mbg.generated
     */
    List<LlmOpsChatHistoryDO> selectByExampleWithBLOBs(LlmOpsChatHistoryDOExample example);

    /**
     *
     * @mbg.generated
     */
    List<LlmOpsChatHistoryDO> selectByExample(LlmOpsChatHistoryDOExample example);

    /**
     *
     * @mbg.generated
     */
    LlmOpsChatHistoryDO selectByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") LlmOpsChatHistoryDO record, @Param("example") LlmOpsChatHistoryDOExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExampleWithBLOBs(@Param("record") LlmOpsChatHistoryDO record, @Param("example") LlmOpsChatHistoryDOExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") LlmOpsChatHistoryDO record, @Param("example") LlmOpsChatHistoryDOExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(LlmOpsChatHistoryDO record);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeyWithBLOBs(LlmOpsChatHistoryDO record);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(LlmOpsChatHistoryDO record);
}
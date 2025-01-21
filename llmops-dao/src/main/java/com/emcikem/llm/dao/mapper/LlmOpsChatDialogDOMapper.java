package com.emcikem.llm.dao.mapper;

import com.emcikem.llm.dao.entity.LlmOpsChatDialogDO;
import com.emcikem.llm.dao.example.LlmOpsChatDialogDOExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LlmOpsChatDialogDOMapper {
    /**
     *
     * @mbg.generated
     */
    long countByExample(LlmOpsChatDialogDOExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByExample(LlmOpsChatDialogDOExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated
     */
    int insert(LlmOpsChatDialogDO record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(LlmOpsChatDialogDO record);

    /**
     *
     * @mbg.generated
     */
    List<LlmOpsChatDialogDO> selectByExampleWithBLOBs(LlmOpsChatDialogDOExample example);

    /**
     *
     * @mbg.generated
     */
    List<LlmOpsChatDialogDO> selectByExample(LlmOpsChatDialogDOExample example);

    /**
     *
     * @mbg.generated
     */
    LlmOpsChatDialogDO selectByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") LlmOpsChatDialogDO record, @Param("example") LlmOpsChatDialogDOExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExampleWithBLOBs(@Param("record") LlmOpsChatDialogDO record, @Param("example") LlmOpsChatDialogDOExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") LlmOpsChatDialogDO record, @Param("example") LlmOpsChatDialogDOExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(LlmOpsChatDialogDO record);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeyWithBLOBs(LlmOpsChatDialogDO record);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(LlmOpsChatDialogDO record);
}
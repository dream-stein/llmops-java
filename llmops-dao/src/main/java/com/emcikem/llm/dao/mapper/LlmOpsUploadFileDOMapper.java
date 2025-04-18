package com.emcikem.llm.dao.mapper;

import com.emcikem.llm.dao.entity.LlmOpsUploadFileDO;
import com.emcikem.llm.dao.example.LlmOpsUploadFileDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LlmOpsUploadFileDOMapper {
    /**
     *
     * @mbg.generated
     */
    long countByExample(LlmOpsUploadFileDOExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByExample(LlmOpsUploadFileDOExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbg.generated
     */
    int insert(LlmOpsUploadFileDO record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(LlmOpsUploadFileDO record);

    /**
     *
     * @mbg.generated
     */
    List<LlmOpsUploadFileDO> selectByExample(LlmOpsUploadFileDOExample example);

    /**
     *
     * @mbg.generated
     */
    LlmOpsUploadFileDO selectByPrimaryKey(String id);

    /**
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") LlmOpsUploadFileDO record, @Param("example") LlmOpsUploadFileDOExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") LlmOpsUploadFileDO record, @Param("example") LlmOpsUploadFileDOExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(LlmOpsUploadFileDO record);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(LlmOpsUploadFileDO record);
}
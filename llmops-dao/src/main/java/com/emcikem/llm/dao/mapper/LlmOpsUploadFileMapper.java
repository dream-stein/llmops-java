package com.emcikem.llm.dao.mapper;

import com.emcikem.llm.dao.entity.LlmOpsUploadFile;
import com.emcikem.llm.dao.example.LlmOpsUploadFileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LlmOpsUploadFileMapper {
    /**
     *
     * @mbg.generated
     */
    long countByExample(LlmOpsUploadFileExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByExample(LlmOpsUploadFileExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String id);

    /**
     *
     * @mbg.generated
     */
    int insert(LlmOpsUploadFile record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(LlmOpsUploadFile record);

    /**
     *
     * @mbg.generated
     */
    List<LlmOpsUploadFile> selectByExample(LlmOpsUploadFileExample example);

    /**
     *
     * @mbg.generated
     */
    LlmOpsUploadFile selectByPrimaryKey(String id);

    /**
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") LlmOpsUploadFile record, @Param("example") LlmOpsUploadFileExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") LlmOpsUploadFile record, @Param("example") LlmOpsUploadFileExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(LlmOpsUploadFile record);

    /**
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(LlmOpsUploadFile record);
}
package com.emcikem.llm.dao.example;

import com.emcikem.llm.dao.entity.LlmOpsChatHistoryDO;
import com.emcikem.llm.dao.entity.LlmOpsChatHistoryDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LlmOpsChatHistoryDOMapper {
    long countByExample(LlmOpsChatHistoryDOExample example);

    int deleteByExample(LlmOpsChatHistoryDOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LlmOpsChatHistoryDO row);

    int insertSelective(LlmOpsChatHistoryDO row);

    List<LlmOpsChatHistoryDO> selectByExampleWithBLOBs(LlmOpsChatHistoryDOExample example);

    List<LlmOpsChatHistoryDO> selectByExample(LlmOpsChatHistoryDOExample example);

    LlmOpsChatHistoryDO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") LlmOpsChatHistoryDO row, @Param("example") LlmOpsChatHistoryDOExample example);

    int updateByExampleWithBLOBs(@Param("row") LlmOpsChatHistoryDO row, @Param("example") LlmOpsChatHistoryDOExample example);

    int updateByExample(@Param("row") LlmOpsChatHistoryDO row, @Param("example") LlmOpsChatHistoryDOExample example);

    int updateByPrimaryKeySelective(LlmOpsChatHistoryDO row);

    int updateByPrimaryKeyWithBLOBs(LlmOpsChatHistoryDO row);

    int updateByPrimaryKey(LlmOpsChatHistoryDO row);
}
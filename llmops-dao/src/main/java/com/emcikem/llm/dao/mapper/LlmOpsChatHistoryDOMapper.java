package com.emcikem.llm.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.emcikem.llm.dao.entity.LlmOpsChatHistoryDO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Create with Emcikem on 2025/1/15
 *
 * @author Emcikem
 * @version 1.0.0
 */
@Mapper
public interface LlmOpsChatHistoryDOMapper extends BaseMapper<LlmOpsChatHistoryDO> {

    @Select("SELECT * FROM llmops_chat_history WHERE id = #{id}")
    LlmOpsChatHistoryDO selectById(Long id);

    @Select("SELECT * FROM llmops_chat_history")
    List<LlmOpsChatHistoryDO> selectAll();

    @Insert("INSERT INTO llmops_chat_history (role, tenant, content, token, creator, operator) " +
            "VALUES (#{role}, #{tenant}, #{content}, #{token}, #{creator}, #{operator})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(LlmOpsChatHistoryDO chatHistory);

    @Update("UPDATE llmops_chat_history SET role = #{role}, tenant = #{tenant}, content = #{content}, " +
            "token = #{token}, creator = #{creator}, operator = #{operator} WHERE id = #{id}")
    int update(LlmOpsChatHistoryDO chatHistory);

    @Delete("DELETE FROM llmops_chat_history WHERE id = #{id}")
    int delete(Long id);
}


package com.emcikem.llm.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.emcikem.llm.dao.entity.LlmOpsChatDialogDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * Create with Emcikem on 2025/1/19
 *
 * @author Emcikem
 * @version 1.0.0
 */
@Mapper
public interface LlmOpsChatDialogDOMapper extends BaseMapper<LlmOpsChatDialogDO> {

    LlmOpsChatDialogDO selectById(Long id);
}

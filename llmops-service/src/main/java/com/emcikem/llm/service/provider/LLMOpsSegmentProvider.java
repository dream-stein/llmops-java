package com.emcikem.llm.service.provider;

import com.emcikem.llm.dao.entity.LlmOpsSegmentDO;
import com.emcikem.llm.dao.mapper.LlmOpsSegmentDOMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Create with Emcikem on 2025/4/13
 *
 * @author Emcikem
 * @version 1.0.0
 */
@Service
public class LLMOpsSegmentProvider {

    @Resource
    private LlmOpsSegmentDOMapper llmOpsSegmentDOMapper;

    public boolean batchInsertSegmentList(List<LlmOpsSegmentDO> segmentList) {
//        llmOpsSegmentDOMapper.batchInsert
        return true;
    }
}

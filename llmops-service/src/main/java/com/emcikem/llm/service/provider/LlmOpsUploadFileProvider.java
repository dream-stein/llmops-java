package com.emcikem.llm.service.provider;

import com.emcikem.llm.common.vo.file.UploadFileVO;
import com.emcikem.llm.dao.entity.LlmOpsUploadFileDO;
import com.emcikem.llm.dao.mapper.LlmOpsUploadFileDOMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * Create with Emcikem on 2025/4/19
 *
 * @author Emcikem
 * @version 1.0.0
 */
@Service
public class LlmOpsUploadFileProvider {

    @Resource
    private LlmOpsUploadFileDOMapper llmOpsUploadFileDOMapper;

    public boolean insertUploadFile(LlmOpsUploadFileDO llmOpsUploadFileDO) {
        return llmOpsUploadFileDOMapper.insert(llmOpsUploadFileDO) == 1;
    }
}

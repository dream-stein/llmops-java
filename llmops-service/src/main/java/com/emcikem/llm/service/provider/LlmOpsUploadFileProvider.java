package com.emcikem.llm.service.provider;

import com.emcikem.llm.dao.entity.LlmOpsUploadFileDO;
import com.emcikem.llm.dao.example.LlmOpsUploadFileDOExample;
import com.emcikem.llm.dao.mapper.LlmOpsUploadFileDOMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public LlmOpsUploadFileDO selectFileByFileId(String fileId) {
        return llmOpsUploadFileDOMapper.selectByPrimaryKey(fileId);
    }

    public List<LlmOpsUploadFileDO> queryUploadFileList(String accountId, List<String> uploadFileIds) {
        LlmOpsUploadFileDOExample example = new LlmOpsUploadFileDOExample();
        example.createCriteria().andAccountIdEqualTo(accountId).andIdIn(uploadFileIds);
        return llmOpsUploadFileDOMapper.selectByExample(example);
    }
}

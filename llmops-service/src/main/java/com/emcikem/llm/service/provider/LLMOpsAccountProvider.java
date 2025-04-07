package com.emcikem.llm.service.provider;

import com.emcikem.llm.dao.entity.LlmOpsAccountDO;
import com.emcikem.llm.dao.mapper.LlmOpsAccountDOMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;


/**
 * Create with Emcikem on 2025/4/8
 *
 * @author Emcikem
 * @version 1.0.0
 */
@Service
public class LLMOpsAccountProvider {

    @Resource
    private LlmOpsAccountDOMapper llmOpsAccountDOMapper;

    public LlmOpsAccountDO getAccountByAccountId(String accountId) {
        return llmOpsAccountDOMapper.selectByPrimaryKey(accountId);
    }

    public boolean updateAccount(String accountId, LlmOpsAccountDO llmOpsAccountDO) {
        llmOpsAccountDO.setId(accountId);
        return llmOpsAccountDOMapper.updateByPrimaryKeySelective(llmOpsAccountDO) == 1;
    }
}

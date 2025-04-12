package com.emcikem.llm.service.service.account;

import com.emcikem.llm.common.vo.account.CurrentUserVO;
import com.emcikem.llm.common.vo.account.UpdateAvatarParam;
import com.emcikem.llm.common.vo.account.UpdateNameParam;
import com.emcikem.llm.common.vo.account.UpdatePasswordParam;
import com.emcikem.llm.dao.entity.LlmOpsAccountDO;
import com.emcikem.llm.service.convert.LLMOpsAccountConvert;
import com.emcikem.llm.service.provider.LLMOpsAccountProvider;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Create with Emcikem on 2025/3/28
 *
 * @author Emcikem
 * @version 1.0.0
 */
@Service
public class LLMOpsAccountService {

    @Resource
    private LLMOpsAccountProvider llmOpsAccountProvider;

    public CurrentUserVO getCurrent() {
        // 1.获取当且账号
        String accountId = getAccountId();

        // 2.获取数据
        LlmOpsAccountDO llmOpsAccountDO = llmOpsAccountProvider.getAccountByAccountId(accountId);
        return LLMOpsAccountConvert.convert2CurrentUser(llmOpsAccountDO);
    }

    public void updatePassword(UpdatePasswordParam param) {
        // 1.获取当且账号
        String accountId = getAccountId();

        LlmOpsAccountDO llmOpsAccountDO = new LlmOpsAccountDO();
        llmOpsAccountDO.setPassword(param.getPassword());
        llmOpsAccountDO.setUpdatedAt(new Date());
        boolean result = llmOpsAccountProvider.updateAccount(accountId, llmOpsAccountDO);
    }

    public void updateName(UpdateNameParam param) {
        // 1.获取当且账号
        String accountId = getAccountId();

        LlmOpsAccountDO llmOpsAccountDO = new LlmOpsAccountDO();
        llmOpsAccountDO.setName(param.getName());
        llmOpsAccountDO.setUpdatedAt(new Date());
        boolean result = llmOpsAccountProvider.updateAccount(accountId, llmOpsAccountDO);
    }

    public void updateAvatar(UpdateAvatarParam param) {
        // 1.获取当且账号
        String accountId = getAccountId();

        LlmOpsAccountDO llmOpsAccountDO = new LlmOpsAccountDO();
        llmOpsAccountDO.setAvatar(param.getAvatar());
        llmOpsAccountDO.setUpdatedAt(new Date());
        boolean result = llmOpsAccountProvider.updateAccount(accountId, llmOpsAccountDO);
    }

    public String getAccountId() {
        return "1";
    }
}

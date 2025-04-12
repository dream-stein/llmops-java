package com.emcikem.llm.service.convert;

import com.emcikem.llm.common.vo.account.CurrentUserVO;
import com.emcikem.llm.dao.entity.LlmOpsAccountDO;

/**
 * Create with Emcikem on 2025/4/8
 *
 * @author Emcikem
 * @version 1.0.0
 */
public class LLMOpsAccountConvert {

    public static CurrentUserVO convert2CurrentUser(LlmOpsAccountDO llmOpsAccountDO) {
        if (llmOpsAccountDO == null) {
            return null;
        }
        CurrentUserVO currentUserVO = new CurrentUserVO();
        currentUserVO.setId(llmOpsAccountDO.getId());
        currentUserVO.setEmail(llmOpsAccountDO.getEmail());
        currentUserVO.setName(llmOpsAccountDO.getName());
        currentUserVO.setAvatar(llmOpsAccountDO.getAvatar());
        currentUserVO.setCreated_at(llmOpsAccountDO.getCreatedAt().getTime());
        currentUserVO.setLast_login_ip(llmOpsAccountDO.getLastLoginIp());
        currentUserVO.setLast_login_at(llmOpsAccountDO.getLastLoginAt().getTime());

        return currentUserVO;
    }

}

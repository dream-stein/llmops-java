package com.emcikem.llm.service.service.assistantagent;

import com.emcikem.llm.common.entity.ApiBasePaginatorResponse;
import com.emcikem.llm.common.entity.Paginator;
import com.emcikem.llm.common.vo.assistantagent.AssistantAgentMessagesVO;
import com.emcikem.llm.dao.entity.LlmOpsAccountDO;
import com.emcikem.llm.dao.entity.LlmOpsMessageDO;
import com.emcikem.llm.service.convert.LLMOpsAssistantConvert;
import com.emcikem.llm.service.provider.LLMOpsAccountProvider;
import com.emcikem.llm.service.provider.LLMOpsMessageProvider;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Create with Emcikem on 2025/3/28
 *
 * @author Emcikem
 * @version 1.0.0
 */
@Service
public class LLMOpsAssistantAgentService {

    @Resource
    private LLMOpsAccountProvider llmOpsAccountProvider;

    @Resource
    private LLMOpsMessageProvider llmOpsMessageProvider;

    public ApiBasePaginatorResponse<AssistantAgentMessagesVO> getAssistantAgentMessagesWithPage(Integer currentPage, Integer pageSize, Long createdAt) {
        // 1. 获取当且账号
        String accountId = getAccountId();

        LlmOpsAccountDO llmOpsAccountDO = llmOpsAccountProvider.getAccountByAccountId(accountId);
        if (llmOpsAccountDO == null) {
            return null;
        }
        String assistantConversationId = llmOpsAccountDO.getAssistantConversationId();
        Long count = llmOpsMessageProvider.countMessageList(createdAt, assistantConversationId);
        Integer offset = (currentPage - 1) * pageSize;
        List<LlmOpsMessageDO> llmOpsMessageList = llmOpsMessageProvider.getMessageList(offset, pageSize, createdAt, assistantConversationId);

        Paginator paginator = new Paginator();
        paginator.setCurrent_page(currentPage);
        paginator.setPage_size(pageSize);
        paginator.setTotal_record(count);
        paginator.setTotal_page((int) ((count + pageSize - 1) / pageSize));

        List<AssistantAgentMessagesVO> assistantAgentMessagesList = LLMOpsAssistantConvert.convert2MessageList(llmOpsMessageList);

        return ApiBasePaginatorResponse.success(assistantAgentMessagesList, paginator);
    }

    private String getAccountId() {
        return "1";
    }
}

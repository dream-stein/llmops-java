package com.emcikem.llm.service.service.apikey;

import com.emcikem.llm.common.entity.ApiBasePaginatorRequest;
import com.emcikem.llm.common.entity.ApiBasePaginatorResponse;
import com.emcikem.llm.common.entity.Paginator;
import com.emcikem.llm.common.vo.apikey.ApiKeysPageVO;
import com.emcikem.llm.common.vo.apikey.CreateApiKeyParam;
import com.emcikem.llm.common.vo.apikey.UpdateApiKeyIsActiveParam;
import com.emcikem.llm.common.vo.apikey.UpdateApiKeyParam;
import com.emcikem.llm.dao.entity.LlmOpsApiKeyDO;
import com.emcikem.llm.service.convert.LLMOpsApiKeyConvert;
import com.emcikem.llm.service.provider.LLMOpsApiKeyProvider;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Create with Emcikem on 2025/3/28
 *
 * @author Emcikem
 * @version 1.0.0
 */
@Service
public class LLMOpsApiKeyService {

    @Resource
    private LLMOpsApiKeyProvider llmOpsApiKeyProvider;

    public void createApiKey(CreateApiKeyParam param) {
        LlmOpsApiKeyDO llmOpsApiKeyDO = new LlmOpsApiKeyDO();
        llmOpsApiKeyDO.setCreatedAt(new Date());
        llmOpsApiKeyDO.setUpdatedAt(new Date());
        llmOpsApiKeyDO.setId(UUID.randomUUID().toString());
        llmOpsApiKeyDO.setApiKey(UUID.randomUUID().toString());
        llmOpsApiKeyDO.setRemark(param.getRemark());
        llmOpsApiKeyDO.setAccountId(getAccountId());
        llmOpsApiKeyDO.setIsActive(param.getIs_active() ? 1 : 0);
        boolean result = llmOpsApiKeyProvider.insertApiKey(llmOpsApiKeyDO);
    }

    public void deleteApiKey(String apiKeyId) {
        // 1. 获取当前账号
        String accountId = getAccountId();

        // 2. 查询apikey
        LlmOpsApiKeyDO llmOpsApiKeyDO = llmOpsApiKeyProvider.selectApiKeyByApiKey(apiKeyId);
        if (llmOpsApiKeyDO == null) {
            return;
        }

        // 3. 判断apikey是否是当且用户创建
        if (!Objects.equals(llmOpsApiKeyDO.getAccountId(), accountId)) {
            return;
        }

        // 4. 删除apikey
        boolean result = llmOpsApiKeyProvider.deleteApiKey(llmOpsApiKeyDO.getId());
    }

    public void updateApiKey(String apiKeyId, UpdateApiKeyParam param) {
        // 1. 获取当前账号
        String accountId = getAccountId();

        // 2. 查询apikey
        LlmOpsApiKeyDO llmOpsApiKeyDO = llmOpsApiKeyProvider.selectApiKeyByApiKey(apiKeyId);
        if (llmOpsApiKeyDO == null) {
            return;
        }

        // 3. 判断apikey是否是当且用户创建
        if (!Objects.equals(llmOpsApiKeyDO.getAccountId(), accountId)) {
            return;
        }

        // 4. 更新数据
        LlmOpsApiKeyDO updateApiKeyDO = new LlmOpsApiKeyDO();
        updateApiKeyDO.setId(llmOpsApiKeyDO.getId());
        updateApiKeyDO.setUpdatedAt(new Date());
        updateApiKeyDO.setRemark(param.getRemark());
        updateApiKeyDO.setIsActive(param.getIs_active() ? 1 : 0);
        boolean result = llmOpsApiKeyProvider.updateApiKey(updateApiKeyDO);
    }

    public void updateApiKeyIsActive(String apiKeyId, UpdateApiKeyIsActiveParam param) {
        // 1. 获取当前账号
        String accountId = getAccountId();

        // 2. 查询apikey
        LlmOpsApiKeyDO llmOpsApiKeyDO = llmOpsApiKeyProvider.selectApiKeyByApiKey(apiKeyId);
        if (llmOpsApiKeyDO == null) {
            return;
        }

        // 3. 判断apikey是否是当且用户创建
        if (!Objects.equals(llmOpsApiKeyDO.getAccountId(), accountId)) {
            return;
        }

        // 4. 更新字段
        LlmOpsApiKeyDO updateApiKeyDO = new LlmOpsApiKeyDO();
        updateApiKeyDO.setIsActive(param.getIs_active() ? 1 : 0);
        updateApiKeyDO.setId(apiKeyId);
        boolean result = llmOpsApiKeyProvider.updateApiKey(updateApiKeyDO);
    }

    public ApiBasePaginatorResponse<ApiKeysPageVO> getAPiKeysWithPage(ApiBasePaginatorRequest request) {
        // 1. 获取当前账号
        String accountId = getAccountId();

        // 2. 数据查询
        Long count = llmOpsApiKeyProvider.countApiKeyList(accountId);
        Integer offset = (request.getCurrent_page() - 1) * request.getPage_size();
        List<LlmOpsApiKeyDO> apiKeyList = llmOpsApiKeyProvider.getApiKeyList(request.getPage_size(), offset, accountId);
        Paginator paginator = new Paginator();
        paginator.setCurrent_page(request.getCurrent_page());
        paginator.setPage_size(request.getPage_size());
        paginator.setTotal_record(count);
        paginator.setTotal_page((int) ((count + request.getPage_size() - 1) / request.getPage_size()));

        return ApiBasePaginatorResponse.success(LLMOpsApiKeyConvert.convert(apiKeyList), paginator);
    }

    private String getAccountId() {
        return "1";
    }
}

package com.emcikem.llm.service.service.apitool;

import com.emcikem.llm.common.entity.ApiBasePaginatorResponse;
import com.emcikem.llm.common.entity.Paginator;
import com.emcikem.llm.common.vo.tools.*;
import com.emcikem.llm.dao.entity.LlmOpsApiToolProviderDO;
import com.emcikem.llm.service.convert.LLMOpsApiToolConvert;
import com.emcikem.llm.service.provider.LLMOpsApiToolProvider;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Create with Emcikem on 2025/3/28
 *
 * @author Emcikem
 * @version 1.0.0
 */
@Service
public class LLMOpsApiToolProviderService {

    @Resource
    private LLMOpsApiToolProvider llmOpsApiToolProvider;

    public ApiBasePaginatorResponse<ApiToolProviderVO> getApiToolProvidersWithPage(String searchWord, Integer currentPage, Integer pageSize) {
        // 1. 获取当前账号
        String accountId = getAccountId();

        // 2. 数据查询
        Long count = llmOpsApiToolProvider.countApiToolProviderList(accountId, searchWord);
        Integer offset = (currentPage - 1) * pageSize;
        List<LlmOpsApiToolProviderDO> apiToolProviderList = llmOpsApiToolProvider.getApiToolProviderList(searchWord, pageSize, offset, accountId);
        Paginator paginator = new Paginator();
        paginator.setCurrent_page(currentPage);
        paginator.setPage_size(pageSize);
        paginator.setTotal_record(count);
        paginator.setTotal_page((int) ((count + pageSize - 1) / pageSize));

        return ApiBasePaginatorResponse.success(LLMOpsApiToolConvert.convert2ApiProviderList(apiToolProviderList), paginator);
    }

    public ApiToolProviderDetailVO getApiToolProvider(String providerId) {
        // 1. 获取当前账号
        String accountId = getAccountId();

        // 2. 查询数据
        LlmOpsApiToolProviderDO apiToolProvider = llmOpsApiToolProvider.getApiToolProvider(accountId, providerId);
        return LLMOpsApiToolConvert.convert2ApiProviderDetail(apiToolProvider);
    }

    public void deleteApiToolProvider(String providerId) {
        // 1. 获取当前账号
        String accountId = getAccountId();

        // 2. 删除数据
        llmOpsApiToolProvider.deleteApiToolProvider(accountId, providerId);
    }

    public void createApiToolProvider(CreateToolProviderParam createToolProviderParam) {
        // 1. 获取当前账号
        String accountId = getAccountId();

        // 2. 创建数据
        LlmOpsApiToolProviderDO llmOpsApiToolProviderDO = new LlmOpsApiToolProviderDO();
        llmOpsApiToolProviderDO.setAccountId(accountId);
        llmOpsApiToolProviderDO.setCreatedAt(new Date());
        llmOpsApiToolProviderDO.setIcon(createToolProviderParam.getIcon());
        llmOpsApiToolProviderDO.setName(createToolProviderParam.getName());
        llmOpsApiToolProviderDO.setUpdatedAt(new Date());
        llmOpsApiToolProviderDO.setId(UUID.randomUUID().toString());
        llmOpsApiToolProvider.createApiToolProvider(llmOpsApiToolProviderDO);
    }

    public void updateApiToolProvider(String providerId, UpdateProviderParam updateProviderParam) {
        // 1. 获取当前账号
        String accountId = getAccountId();

        // 2. 更新数据
        LlmOpsApiToolProviderDO llmOpsApiToolProviderDO = new LlmOpsApiToolProviderDO();
        llmOpsApiToolProviderDO.setIcon(updateProviderParam.getIcon());
        llmOpsApiToolProviderDO.setName(updateProviderParam.getName());

//        llmOpsApiToolProvider.updateApiToolProvider(providerId, accountId, llmOpsApiToolProviderDO);
    }

    private String getAccountId() {
        return "1";
    }
}

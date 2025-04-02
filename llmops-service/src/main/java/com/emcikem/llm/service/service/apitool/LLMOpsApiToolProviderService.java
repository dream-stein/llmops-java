package com.emcikem.llm.service.service.apitool;

import com.emcikem.llm.common.entity.ApiBasePaginatorResponse;
import com.emcikem.llm.common.entity.Paginator;
import com.emcikem.llm.common.vo.tools.ApiToolProviderVO;
import com.emcikem.llm.common.vo.tools.ApiToolProviderDetailVO;
import com.emcikem.llm.common.vo.tools.GetApiToolVO;
import com.emcikem.llm.dao.entity.LlmOpsApiToolProviderDO;
import com.emcikem.llm.service.convert.LLMOpsApiToolConvert;
import com.emcikem.llm.service.provider.LLMOpsApiToolProvider;
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

    private String getAccountId() {
        return "1";
    }

    public GetApiToolVO getApiTool(String providerId, String toolName) {
        return null;
    }
}

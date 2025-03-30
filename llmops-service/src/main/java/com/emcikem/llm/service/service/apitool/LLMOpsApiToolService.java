package com.emcikem.llm.service.service.apitool;

import com.emcikem.llm.common.entity.ApiBasePaginatorResponse;
import com.emcikem.llm.common.entity.Paginator;
import com.emcikem.llm.common.vo.tools.ApiProviderVO;
import com.emcikem.llm.common.vo.tools.ApiToolVO;
import com.emcikem.llm.dao.entity.LlmOpsApiToolDO;
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
public class LLMOpsApiToolService {

    @Resource
    private LLMOpsApiToolProvider llmOpsApiToolProvider;

    public ApiBasePaginatorResponse<ApiToolVO> getApiToolProvidersWithPage(String searchWord, Integer currentPage, Integer pageSize) {
        // 1. 获取当前账号
        String accountId = getAccountId();

        // 2. 数据查询
        Long count = llmOpsApiToolProvider.countApiToolList(accountId, searchWord);
        Integer offset = (pageSize - 1) * pageSize;
        List<LlmOpsApiToolDO> apiToolList = llmOpsApiToolProvider.getApiToolProviderList(searchWord, pageSize, offset, accountId);
        Paginator paginator = new Paginator();
        paginator.setCurrent_page(currentPage);
        paginator.setPage_size(pageSize);
        paginator.setTotal_page(count);
        paginator.setTotal_record((int) ((count + pageSize - 1) / pageSize));

        return ApiBasePaginatorResponse.success(LLMOpsApiToolConvert.convert(apiToolList), paginator);
    }

    private String getAccountId() {
        return "1";
    }
}

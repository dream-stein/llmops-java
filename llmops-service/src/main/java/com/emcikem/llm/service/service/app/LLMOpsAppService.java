package com.emcikem.llm.service.service.app;

import com.emcikem.llm.common.entity.ApiBasePaginatorResponse;
import com.emcikem.llm.common.entity.Paginator;
import com.emcikem.llm.common.vo.apps.AppVO;
import com.emcikem.llm.dao.entity.LlmOpsAppDO;
import com.emcikem.llm.service.convert.LLMOpsAppConvert;
import com.emcikem.llm.service.provider.LLMOpsAppProvider;
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
public class LLMOpsAppService {

    @Resource
    private LLMOpsAppProvider llmOpsAppProvider;

    public ApiBasePaginatorResponse<AppVO> getDatasetsWithPage(String searchWord, Integer currentPage, Integer pageSize) {
        // 1. 查询当前账号
        String accountId = getAccountId();

        // 2. 数据查询
        Long count = llmOpsAppProvider.countAppList(accountId, searchWord);
        Integer offset = (currentPage - 1) * pageSize;
        List<LlmOpsAppDO> appList = llmOpsAppProvider.getAppList(pageSize, offset, accountId, searchWord);

        Paginator paginator = new Paginator();
        paginator.setCurrent_page(currentPage);
        paginator.setPage_size(pageSize);
        paginator.setTotal_record(count);
        paginator.setTotal_page((int) ((count + pageSize - 1) / pageSize));

        return ApiBasePaginatorResponse.success(LLMOpsAppConvert.convert(appList), paginator);

    }

    private String getAccountId() {
        return "1";
    }
}

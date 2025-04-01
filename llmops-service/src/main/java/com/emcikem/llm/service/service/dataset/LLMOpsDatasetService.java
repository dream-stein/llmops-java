package com.emcikem.llm.service.service.dataset;

import com.emcikem.llm.common.entity.ApiBasePaginatorResponse;
import com.emcikem.llm.common.entity.Paginator;
import com.emcikem.llm.common.vo.dataset.DatasetDetailVO;
import com.emcikem.llm.common.vo.dataset.DatasetQueryVO;
import com.emcikem.llm.common.vo.dataset.DatasetVO;
import com.emcikem.llm.dao.entity.LlmOpsDatasetDO;
import com.emcikem.llm.dao.entity.LlmOpsDatasetQueryDO;
import com.emcikem.llm.service.convert.LLMOpsDatasetConvert;
import com.emcikem.llm.service.provider.LLMOpsDatasetProvider;
import com.emcikem.llm.service.provider.LLMOpsDatasetQueryProvider;
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
public class LLMOpsDatasetService {

    @Resource
    private LLMOpsDatasetProvider llmOpsDatasetProvider;

    @Resource
    private LLMOpsDatasetQueryProvider llmOpsDatasetQueryProvider;

    public ApiBasePaginatorResponse<DatasetVO> getDatasetsWithPage(String searchWord, Integer currentPage, Integer pageSize) {
        // 1. 查询当前账号
        String accountId = getAccountId();

        // 2. 数据查询
        Long count = llmOpsDatasetProvider.countDatasetList(accountId, searchWord);
        Integer offset = (currentPage - 1) * pageSize;
        List<LlmOpsDatasetDO> datasetList = llmOpsDatasetProvider.getDatasetList(pageSize, offset, accountId, searchWord);

        Paginator paginator = new Paginator();
        paginator.setCurrent_page(currentPage);
        paginator.setPage_size(pageSize);
        paginator.setTotal_record(count);
        paginator.setTotal_page((int) ((count + pageSize - 1) / pageSize));

        return ApiBasePaginatorResponse.success(LLMOpsDatasetConvert.convert(datasetList), paginator);
    }

    public DatasetDetailVO getDataset(String datasetId) {
        // 1. 查询当前账号
        String accountId = getAccountId();

        // 2. 查询数据
        LlmOpsDatasetDO llmOpsDatasetDO = llmOpsDatasetProvider.getDataset(datasetId, accountId);

        return LLMOpsDatasetConvert.convert2DetailVO(llmOpsDatasetDO);
    }

    public List<DatasetQueryVO> getDatasetQueries(String datasetId) {
        List<LlmOpsDatasetQueryDO> datasetQueryList = llmOpsDatasetQueryProvider.getDatasetQueries(datasetId);

        return LLMOpsDatasetConvert.convert2QueryList(datasetQueryList);
    }

    private String getAccountId() {
        return "1";
    }
}

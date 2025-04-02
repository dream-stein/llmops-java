package com.emcikem.llm.service.service.dataset;

import com.emcikem.llm.common.entity.ApiBasePaginatorResponse;
import com.emcikem.llm.common.entity.Paginator;
import com.emcikem.llm.common.vo.dataset.*;
import com.emcikem.llm.dao.entity.LlmOpsDatasetDO;
import com.emcikem.llm.dao.entity.LlmOpsDatasetQueryDO;
import com.emcikem.llm.dao.entity.LlmOpsDocumentDO;
import com.emcikem.llm.service.convert.LLMOpsDatasetConvert;
import com.emcikem.llm.service.provider.LLMOpsDatasetProvider;
import com.emcikem.llm.service.provider.LLMOpsDatasetQueryProvider;
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

    public void deleteDataset(String datasetId) {
        // 1. 查询当前账号
        String accountId = getAccountId();

        boolean result = llmOpsDatasetProvider.deleteDataset(accountId, datasetId);
    }

    public void updateDataset(String datasetId, UpdateDatasetParam updateDatasetParam) {
        // 1. 查询当前账号
        String accountId = getAccountId();

        // 2. 更新数据
        LlmOpsDatasetDO llmOpsDatasetDO = new LlmOpsDatasetDO();
        llmOpsDatasetDO.setIcon(updateDatasetParam.getIcon());
        llmOpsDatasetDO.setDescription(updateDatasetParam.getDescription());
        llmOpsDatasetDO.setName(updateDatasetParam.getName());
        llmOpsDatasetDO.setUpdatedAt(new Date());
        llmOpsDatasetProvider.updateDataset(datasetId, accountId, llmOpsDatasetDO);

    }

    public void createDataset(CreateDatasetParam createDatasetParam) {
        // 1. 查询当前账号
        String accountId = getAccountId();

        // 2. 创建数据
        LlmOpsDatasetDO llmOpsDatasetDO = new LlmOpsDatasetDO();
        llmOpsDatasetDO.setCreatedAt(new Date());
        llmOpsDatasetDO.setId(UUID.randomUUID().toString());
        llmOpsDatasetDO.setAccountId(accountId);
        llmOpsDatasetDO.setUpdatedAt(new Date());
        llmOpsDatasetDO.setName(createDatasetParam.getName());
        llmOpsDatasetDO.setDescription(createDatasetParam.getDescription());
        llmOpsDatasetDO.setIcon(createDatasetParam.getIcon());
        llmOpsDatasetProvider.createDataset(llmOpsDatasetDO);
    }

    public void updateDocumentName(String datasetId, String documentId, UpdateDocumentNameParam param) {
        // 1. 查询当前账号
        String accountId = getAccountId();

        // 2. 更新文档名称
        LlmOpsDocumentDO llmOpsDocumentDO = new LlmOpsDocumentDO();
        llmOpsDocumentDO.setName(param.getName());
        llmOpsDocumentDO.setUpdatedAt(new Date());
        llmOpsDatasetProvider.updateDocument(datasetId, documentId, accountId, llmOpsDocumentDO);
    }

    public void deleteDocument(String datasetId, String documentId) {
        // 1. 查询当前账号
        String accountId = getAccountId();

        // 2. 删除文档
        llmOpsDatasetProvider.deleteDocument(datasetId, documentId, accountId);
    }

    public void updateDocumentEnabled(String datasetId, String documentId, UpdateDocumentEnabledParam param) {
        // 1. 查询当前账号
        String accountId = getAccountId();

        // 2. 更新文档状态
        LlmOpsDocumentDO llmOpsDocumentDO = new LlmOpsDocumentDO();
        llmOpsDocumentDO.setEnabled(param.getEnabled());
        llmOpsDocumentDO.setUpdatedAt(new Date());
        llmOpsDatasetProvider.updateDocument(datasetId, documentId, accountId, llmOpsDocumentDO);
    }

    public DocumentDetailVO getDocument(String datasetId, String documentId) {
        // 1. 查询当前账号
        String accountId = getAccountId();

        // 2. 查询文档
        LlmOpsDocumentDO llmOpsDocumentDO = llmOpsDatasetProvider.getDocument(accountId, datasetId, documentId);
        return LLMOpsDatasetConvert.convertDocumentDetail(llmOpsDocumentDO);
    }

    public ApiBasePaginatorResponse<DocumentVO> getDocumentsWithPage(String datasetId, String searchWord, Integer currentPage, Integer pageSize) {
        // 1. 查询当前账号
        String accountId = getAccountId();

        // 2. 数据查询
        Long count = llmOpsDatasetProvider.countDocumentList(accountId, searchWord);
        Integer offset = (currentPage - 1) * pageSize;
        List<LlmOpsDocumentDO> documentList = llmOpsDatasetProvider.getDocumentList(pageSize, offset, accountId, searchWord);

        Paginator paginator = new Paginator();
        paginator.setCurrent_page(currentPage);
        paginator.setPage_size(pageSize);
        paginator.setTotal_record(count);
        paginator.setTotal_page((int) ((count + pageSize - 1) / pageSize));

        return ApiBasePaginatorResponse.success(LLMOpsDatasetConvert.convertDocumentList(documentList), paginator);
    }

    private String getAccountId() {
        return "1";
    }
}

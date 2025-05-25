package com.emcikem.llm.service.service.dataset;

import com.emcikem.llm.common.entity.ApiBasePaginatorResponse;
import com.emcikem.llm.common.entity.Paginator;
import com.emcikem.llm.common.enums.LlmOpsResultEnum;
import com.emcikem.llm.common.exception.LlmOpsException;
import com.emcikem.llm.common.util.GsonUtil;
import com.emcikem.llm.common.vo.dataset.*;
import com.emcikem.llm.dao.entity.LlmOpsDatasetDO;
import com.emcikem.llm.dao.entity.LlmOpsDatasetQueryDO;
import com.emcikem.llm.dao.entity.LlmOpsDocumentDO;
import com.emcikem.llm.dao.entity.LlmOpsProcessRuleDO;
import com.emcikem.llm.dao.entity.LlmOpsSegmentDO;
import com.emcikem.llm.dao.entity.LlmOpsUploadFileDO;
import com.emcikem.llm.service.constant.LLMOpsConstant;
import com.emcikem.llm.service.convert.LLMOpsDatasetConvert;
import com.emcikem.llm.service.provider.LLMOpsAppDatasetJoinProvider;
import com.emcikem.llm.service.provider.LLMOpsDatasetProvider;
import com.emcikem.llm.service.provider.LLMOpsDatasetQueryProvider;
import com.emcikem.llm.service.provider.LLMOpsProcessRuleProvider;
import com.emcikem.llm.service.provider.LlmOpsUploadFileProvider;
import jakarta.annotation.Resource;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.compress.utils.Lists;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.stream.Collectors;

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

    @Resource
    private LLMOpsAppDatasetJoinProvider llmOpsAppDatasetJoinProvider;

    @Resource
    private LlmOpsUploadFileProvider llmOpsUploadFileProvider;

    @Resource
    private LLMOpsProcessRuleProvider llmOpsProcessRuleProvider;

    @Resource
    private ExecutorService taskPool;

    @Resource
    private LLMOpsDocumentTask llmOpsDocumentTask;

    public ApiBasePaginatorResponse<DatasetVO> getDatasetsWithPage(String searchWord, Integer currentPage, Integer pageSize) {
        // 1. 查询当前账号
        String accountId = getAccountId();

        // 2. 数据查询
        Long count = llmOpsDatasetProvider.countDatasetList(accountId, searchWord);
        Integer offset = (currentPage - 1) * pageSize;
        List<LlmOpsDatasetDO> datasetList = llmOpsDatasetProvider.getDatasetList(pageSize, offset, accountId, searchWord);
        List<String> databaseIdList = datasetList.stream().map(LlmOpsDatasetDO::getId).collect(Collectors.toList());
        Map<String, Long> characterCountMap = llmOpsDatasetProvider.sumDocumentCharacterCountByDataBaseIdList(accountId, databaseIdList);
        Map<String, Integer> relationAppCountMap = llmOpsAppDatasetJoinProvider.countAppDatasetJoinByDataBaseIdList(databaseIdList);
        Map<String, Integer> documentCountMap = llmOpsDatasetProvider.countDocumentByDataBaseIdList(accountId, databaseIdList);

        // 3. 构建返回参数
        List<DatasetVO> datasetVOList = buildDatasetVOList(datasetList, characterCountMap, relationAppCountMap, documentCountMap);
        return ApiBasePaginatorResponse.success(datasetVOList, buildPaginator(currentPage, pageSize, count));
    }

    private Paginator buildPaginator(Integer currentPage, Integer pageSize, Long count) {
        Paginator paginator = new Paginator();
        paginator.setCurrent_page(currentPage);
        paginator.setPage_size(pageSize);
        paginator.setTotal_record(count);
        paginator.setTotal_page((int) ((count + pageSize - 1) / pageSize));

        return paginator;
    }

    private List<DatasetVO> buildDatasetVOList(List<LlmOpsDatasetDO> datasetDOList, Map<String, Long> characterCountMap, Map<String, Integer> relationAppCountMap, Map<String, Integer> documentCountMap) {
        List<DatasetVO> datasetVOList = LLMOpsDatasetConvert.convert(datasetDOList);
        datasetVOList.stream().forEach(datasetVO -> {
            datasetVO.setCharacter_count(MapUtils.getInteger(characterCountMap, datasetVO.getId(), 0));
            datasetVO.setRelated_app_count(MapUtils.getInteger(relationAppCountMap, datasetVO.getId(), 0));
            datasetVO.setDocument_count(MapUtils.getInteger(documentCountMap, datasetVO.getId(), 0));
        });

        return datasetVOList;
    }

    public DatasetDetailVO getDataset(String datasetId) {
        // 1. 查询当前账号
        String accountId = getAccountId();

        // 2. 查询数据
        LlmOpsDatasetDO llmOpsDatasetDO = llmOpsDatasetProvider.getDataset(datasetId, accountId);
        Long documentCount = llmOpsDatasetProvider.countDocumentList(accountId, "", datasetId);
        Long hitCount = llmOpsDatasetProvider.sumSegmentHitCount(accountId, datasetId);
        Long characterCount = llmOpsDatasetProvider.sumDocumentCharacterCount(accountId, datasetId);
        Long relatedAppCount = llmOpsAppDatasetJoinProvider.countAppDatasetJoin(datasetId);

        // 3. 构建返回参数
        DatasetDetailVO datasetDetailVO = LLMOpsDatasetConvert.convert2DetailVO(llmOpsDatasetDO);
        datasetDetailVO.setDocument_count(Optional.ofNullable(documentCount).map(Math::toIntExact).orElse(0));
        datasetDetailVO.setHit_count(Optional.ofNullable(hitCount).map(Math::toIntExact).orElse(0));
        datasetDetailVO.setCharacter_count(Optional.ofNullable(characterCount).map(Math::toIntExact).orElse(0));
        datasetDetailVO.setRelated_app_count(Optional.ofNullable(relatedAppCount).map(Math::toIntExact).orElse(0));

        return datasetDetailVO;
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

    public void updateDataset(String datasetId, UpdateDatasetParam param) {
        // 1. 查询当前账号
        String accountId = getAccountId();

        // 2. 查询数据
        LlmOpsDatasetDO llmOpsDatasetDO = llmOpsDatasetProvider.getDataset(datasetId, accountId);
        if (llmOpsDatasetDO == null) {
            throw new LlmOpsException(LlmOpsResultEnum.DATASET_NOT_FOUND);
        }

        // 3. 检测名称是否出现重名
        LlmOpsDatasetDO datasetByAccountAndNameAndId = llmOpsDatasetProvider.getDatasetByAccountAndNameAndId(datasetId, accountId, param.getName());
        if (datasetByAccountAndNameAndId != null) {
            throw new LlmOpsException(LlmOpsResultEnum.DATASET_HAS_SAME_NAME);
        }

        // 4. 检测是否传递了描述信息，如果没有传递则补充上
        if (StringUtils.isEmpty(param.getDescription())) {
            param.setDescription(String.format(LLMOpsConstant.DEFAULT_DATASET_DESCRIPTION_FORMATTER, param.getName()));
        }

        // 5. 更新数据
        LlmOpsDatasetDO updateDatasetDO = buildUpdateDatasetDO(param);
        boolean result = llmOpsDatasetProvider.updateDataset(datasetId, accountId, updateDatasetDO);
        if (!result) {
            throw new LlmOpsException(LlmOpsResultEnum.UPDATE_DATASET_FAILED);
        }
    }

    private LlmOpsDatasetDO buildUpdateDatasetDO(UpdateDatasetParam param) {
        LlmOpsDatasetDO llmOpsDatasetDO = new LlmOpsDatasetDO();
        llmOpsDatasetDO.setIcon(param.getIcon());
        llmOpsDatasetDO.setDescription(param.getDescription());
        llmOpsDatasetDO.setName(param.getName());
        llmOpsDatasetDO.setUpdatedAt(new Date());
        return llmOpsDatasetDO;
    }

    public void createDataset(CreateDatasetParam param) {
        // 1. 查询当前账号
        String accountId = getAccountId();

        // 2. 检测该账号下是否存在同名知识库
        LlmOpsDatasetDO datasetByAccountAndName = llmOpsDatasetProvider.getDatasetByAccountAndName(accountId, param.getName());
        if (datasetByAccountAndName != null) {
            throw new LlmOpsException(LlmOpsResultEnum.DATASET_HAS_SAME_NAME);
        }

        // 3. 检测是否传递了描述信息，如果没有传递则补充上
        if (StringUtils.isEmpty(param.getDescription())) {
            param.setDescription(String.format(LLMOpsConstant.DEFAULT_DATASET_DESCRIPTION_FORMATTER, param.getDescription()));
        }

        // 4. 创建知识库记录并返回
        LlmOpsDatasetDO llmOpsDatasetDO = buildDatasetDO(accountId, param);
        boolean result = llmOpsDatasetProvider.createDataset(llmOpsDatasetDO);
        if (!result) {
            throw new LlmOpsException(LlmOpsResultEnum.UPDATE_DATASET_FAILED);
        }
    }

    private LlmOpsDatasetDO buildDatasetDO(String accountId, CreateDatasetParam parm) {
        LlmOpsDatasetDO llmOpsDatasetDO = new LlmOpsDatasetDO();
        llmOpsDatasetDO.setCreatedAt(new Date());
        llmOpsDatasetDO.setId(UUID.randomUUID().toString());
        llmOpsDatasetDO.setAccountId(accountId);
        llmOpsDatasetDO.setUpdatedAt(new Date());
        llmOpsDatasetDO.setName(parm.getName());
        llmOpsDatasetDO.setDescription(parm.getDescription());
        llmOpsDatasetDO.setIcon(parm.getIcon());

        return llmOpsDatasetDO;
    }

    public void updateDocument(String datasetId, String documentId, UpdateDocumentNameParam param) {
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
        Long count = llmOpsDatasetProvider.countDocumentList(accountId, datasetId, searchWord);
        Integer offset = (currentPage - 1) * pageSize;
        List<LlmOpsDocumentDO> documentList = llmOpsDatasetProvider.getDocumentList(pageSize, offset, accountId, datasetId, searchWord);

        Paginator paginator = new Paginator();
        paginator.setCurrent_page(currentPage);
        paginator.setPage_size(pageSize);
        paginator.setTotal_record(count);
        paginator.setTotal_page((int) ((count + pageSize - 1) / pageSize));

        return ApiBasePaginatorResponse.success(LLMOpsDatasetConvert.convertDocumentList(documentList), paginator);
    }

    public ApiBasePaginatorResponse<SegmentVO> getSegmentsWithPage(String datasetId, String documentId, String searchWord, Integer currentPage, Integer pageSize) {
        // 1. 查询当前账号
        String accountId = getAccountId();

        // 2. 数据查询
        Long count = llmOpsDatasetProvider.countSegmentList(datasetId, documentId, accountId, searchWord);
        Integer offset = (currentPage - 1) * pageSize;
        List<LlmOpsSegmentDO> segmentList = llmOpsDatasetProvider.getSegmentList(pageSize, offset, accountId, searchWord, datasetId, documentId);

        Paginator paginator = new Paginator();
        paginator.setCurrent_page(currentPage);
        paginator.setPage_size(pageSize);
        paginator.setTotal_record(count);
        paginator.setTotal_page((int) ((count + pageSize - 1) / pageSize));

        return ApiBasePaginatorResponse.success(LLMOpsDatasetConvert.convertSegmentList(segmentList), paginator);
    }

    public SegmentDetailVO getSegment(String datasetId, String documentId, String segmentId) {
        // 1. 查询当前账号
        String accountId = getAccountId();

        // 2. 数据查询
        LlmOpsSegmentDO segment = llmOpsDatasetProvider.getSegment(datasetId, documentId, segmentId, accountId);
        return LLMOpsDatasetConvert.convert2SegmentDetail(segment);
    }

    public void updateSegmentEnabled(String datasetId, String documentId, String segmentId, UpdateSegmentEnabledParam param) {
        // 1. 查询当前账号
        String accountId = getAccountId();

        // 2. 修改数据
        LlmOpsSegmentDO llmOpsSegmentDO = new LlmOpsSegmentDO();
        llmOpsSegmentDO.setEnabled(param.getEnabled());
        llmOpsSegmentDO.setUpdatedAt(new Date());
        boolean result = llmOpsDatasetProvider.updateSegment(datasetId, documentId, segmentId, accountId, llmOpsSegmentDO);
    }

    public void deleteSegment(String datasetId, String documentId, String segmentId) {
        // 1. 查询当前账号
        String accountId = getAccountId();

        // 2. 删除数据
        boolean result = llmOpsDatasetProvider.deleteSegment(datasetId, documentId, segmentId, accountId);
    }

    public void createSegment(String datasetId, String documentId, CreateSegmentParam param) {
        // 1. 查询当前账号
        String accountId = getAccountId();

        // 2. 添加数据
        LlmOpsSegmentDO llmOpsSegmentDO = new LlmOpsSegmentDO();
        llmOpsSegmentDO.setId(UUID.randomUUID().toString());
        llmOpsSegmentDO.setCreatedAt(new Date());
        llmOpsSegmentDO.setUpdatedAt(new Date());
        llmOpsSegmentDO.setDocumentId(documentId);
        llmOpsSegmentDO.setDatasetId(datasetId);
        llmOpsSegmentDO.setAccountId(accountId);
        llmOpsSegmentDO.setKeywords(GsonUtil.toJSONString(param.getKeywords()));
        llmOpsSegmentDO.setContent(param.getContent());

        // TODO:
        llmOpsSegmentDO.setEnabled(true);
        llmOpsSegmentDO.setCompletedAt(new Date());
        llmOpsSegmentDO.setNodeId("11");
        llmOpsSegmentDO.setHitCount(1);
        llmOpsSegmentDO.setCharacterCount(1);
        llmOpsSegmentDO.setTokenCount(1);
        llmOpsSegmentDO.setPosition(1);
        llmOpsSegmentDO.setHash(UUID.randomUUID().toString());
        llmOpsSegmentDO.setStatus("completed");
        llmOpsSegmentDO.setDisabledAt(new Date());
        llmOpsSegmentDO.setProcessingStartedAt(new Date());
        llmOpsSegmentDO.setIndexCompletedAt(new Date());
        llmOpsSegmentDO.setStoppedAt(new Date());
        boolean resul = llmOpsDatasetProvider.createSegment(llmOpsSegmentDO);
    }

    public void updateSegment(String datasetId, String documentId, String segmentId, UpdateSegmentParam param) {
        // 1. 查询当前账号
        String accountId = getAccountId();

        // 2. 修改数据
        LlmOpsSegmentDO llmOpsSegmentDO = new LlmOpsSegmentDO();
        llmOpsSegmentDO.setUpdatedAt(new Date());
        llmOpsSegmentDO.setContent(param.getContent());
        llmOpsSegmentDO.setKeywords(GsonUtil.toJSONString(param.getKeywords()));
        boolean resul = llmOpsDatasetProvider.updateSegment(datasetId, documentId, segmentId, accountId, llmOpsSegmentDO);
    }

    public CreatedDocumentsVO createDocuments(String datasetId, CreateDocumentsParam param) {
        // 1. 查询当前账号
        String accountId = getAccountId();

        // 2. 检测知识库权限
        LlmOpsDatasetDO dataset = llmOpsDatasetProvider.getDataset(datasetId, accountId);
        if (dataset == null) {
            throw new LlmOpsException(LlmOpsResultEnum.DATASET_NOT_FOUND);
        }

        // 3. 提取文件并校验文件权限与文件扩展
        List<LlmOpsUploadFileDO> llmOpsUploadFileList = llmOpsUploadFileProvider.queryUploadFileList(accountId, param.getUpload_file_ids());
        List<LlmOpsUploadFileDO> uploadFiles = llmOpsUploadFileList.stream()
                .filter(x -> LLMOpsConstant.ALLOWED_DOCUMENT_EXTENSION.contains(x.getExtension())).toList();

        if (CollectionUtils.isEmpty(uploadFiles)) {
            throw new LlmOpsException(LlmOpsResultEnum.CAN_NOT_FIND_VALID_DOCUMENT);
        }

        // 4. 创建批次与处理规则并记录到数据库中
        String batch = String.format("%s%S", new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()), 100000 + new Random().nextInt(900000));
        LlmOpsProcessRuleDO llmOpsProcessRuleDO = buildProcessRuleDO(datasetId, accountId, param.getProcess_type(), GsonUtil.toJSONString(param.getRule()));
        boolean result = llmOpsProcessRuleProvider.insert(llmOpsProcessRuleDO);

        // 5. 获取当且知识库的最新文档位置
        Integer position = getLatestDocumentPosition(datasetId);

        // 6. 循环所有合法的上传文件列表并记录
        List<LlmOpsDocumentDO> documentList = buildDocumentDOList(batch, position, uploadFiles, accountId, datasetId, llmOpsProcessRuleDO);

        // 7. 调用异步任务，完成后续操作
        List<String> doucmnetIdList = documentList.stream().map(LlmOpsDocumentDO::getId).toList();
        taskPool.execute(() -> llmOpsDocumentTask.buildDocumentsAsync(doucmnetIdList));

        // 8. 返回文档列表与处理批次
        return buildDocumentVO(documentList, batch);
    }

    private List<LlmOpsDocumentDO> buildDocumentDOList(String batch, Integer position, List<LlmOpsUploadFileDO> uploadFiles, String accountId, String datasetId, LlmOpsProcessRuleDO llmOpsProcessRuleDO) {
        List<LlmOpsDocumentDO> llmOpsDocumentList = Lists.newArrayList();
        for (LlmOpsUploadFileDO uploadFile : uploadFiles) {
            position += 1;
            LlmOpsDocumentDO llmOpsDocumentDO = new LlmOpsDocumentDO();
            llmOpsDocumentDO.setId(UUID.randomUUID().toString());
            llmOpsDocumentDO.setAccountId(accountId);
            llmOpsDocumentDO.setDatasetId(datasetId);
            llmOpsDocumentDO.setUploadFileId(uploadFile.getId());
            llmOpsDocumentDO.setProcessRuleId(llmOpsProcessRuleDO.getId());
            llmOpsDocumentDO.setBatch(batch);
            llmOpsDocumentDO.setName(uploadFile.getName());
            llmOpsDocumentDO.setPosition(position);
            llmOpsDocumentDO.setId(UUID.randomUUID().toString());

            llmOpsDocumentList.add(llmOpsDocumentDO);
        }
        return llmOpsDocumentList;
    }

    private Integer getLatestDocumentPosition(String datasetId) {
        return llmOpsDatasetProvider.getLatestDocumentPosition(datasetId);
    }

    private LlmOpsProcessRuleDO buildProcessRuleDO(String datasetId, String accountId, String mode, String rule) {
        LlmOpsProcessRuleDO llmOpsProcessRuleDO = new LlmOpsProcessRuleDO();
        llmOpsProcessRuleDO.setId(UUID.randomUUID().toString());
        llmOpsProcessRuleDO.setDatasetId(datasetId);
        llmOpsProcessRuleDO.setRule(rule);
        llmOpsProcessRuleDO.setUpdatedAt(new Date());
        llmOpsProcessRuleDO.setCreatedAt(new Date());
        llmOpsProcessRuleDO.setAccountId(accountId);
        llmOpsProcessRuleDO.setMode(mode);

        return llmOpsProcessRuleDO;
    }

    private CreatedDocumentsVO buildDocumentVO(List<LlmOpsDocumentDO> documents, String batch) {
        CreatedDocumentsVO createdDocumentsVO = new CreatedDocumentsVO();
        createdDocumentsVO.setBatch(batch);
        createdDocumentsVO.setDocument(LLMOpsDatasetConvert.convertDocumentList(documents));

        return createdDocumentsVO;
    }

    private String getAccountId() {
        return "1";
    }
}

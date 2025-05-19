package com.emcikem.llm.web.controller;

import com.emcikem.llm.common.entity.ApiBasePaginatorResponse;
import com.emcikem.llm.common.entity.ApiResponse;
import com.emcikem.llm.common.enums.ResponseStatusEnum;
import com.emcikem.llm.common.vo.dataset.*;
import com.emcikem.llm.service.service.dataset.LLMOpsDatasetService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Create with Emcikem on 2025/3/14
 *
 * @author Emcikem
 * @version 1.0.0
 * @Description: 知识库接口 19个接口
 */
@RestController
@RequestMapping("/datasets")
public class LLMOpsDatasetController {

    @Resource
    private LLMOpsDatasetService llmOpsDatasetService;

    /**
     * 获取知识库分页列表数据
     * @param searchWord
     * @param currentPage
     * @param pageSize
     * @return
     */
    @GetMapping
    public ApiBasePaginatorResponse<DatasetVO> getDatasetsWithPage(@RequestParam(value = "search_word", required = false) String searchWord,
                                                                   @RequestParam("current_page") Integer currentPage,
                                                                   @RequestParam("page_size") Integer pageSize) {
        try {
            return llmOpsDatasetService.getDatasetsWithPage(searchWord, currentPage, pageSize);
        } catch (IllegalArgumentException ex) {
            return ApiBasePaginatorResponse.error(ResponseStatusEnum.VALIDATE_ERROR);
        } catch (Exception ex) {
            return ApiBasePaginatorResponse.error(ResponseStatusEnum.SYSTEM_ERROR);
        }
    }

    /**
     * 新增知识库
     * @param createDatasetParam
     * @return
     */
    @PostMapping
    public ApiResponse<Void> createDataset(@RequestBody CreateDatasetParam createDatasetParam) {
        try {
            llmOpsDatasetService.createDataset(createDatasetParam);
            return ApiResponse.success(null);
        } catch (IllegalArgumentException ex) {
            return ApiResponse.error(ResponseStatusEnum.VALIDATE_ERROR);
        } catch (Exception ex) {
            return ApiResponse.error(ResponseStatusEnum.SYSTEM_ERROR);
        }
    }

    /**
     * 更新知识库
     * @param datasetId
     * @param updateDatasetParam
     * @return
     */
    @PostMapping("/{dataset_id}")
    public ApiResponse<Void> updateDataset(@PathVariable("dataset_id") String datasetId,
                                           @RequestBody UpdateDatasetParam updateDatasetParam) {
        try {
            llmOpsDatasetService.updateDataset(datasetId, updateDatasetParam);
            return ApiResponse.success(null);
        } catch (IllegalArgumentException ex) {
            return ApiResponse.error(ResponseStatusEnum.VALIDATE_ERROR);
        } catch (Exception ex) {
            return ApiResponse.error(ResponseStatusEnum.SYSTEM_ERROR);
        }
    }

    /**
     * 删除知识库请求
     * @param datasetId
     * @return
     */
    @PostMapping("/{dataset_id}/delete")
    public ApiResponse<Void> deleteDataset(@PathVariable("dataset_id") String datasetId) {
        llmOpsDatasetService.deleteDataset(datasetId);
        return ApiResponse.success(null);
    }

    /**
     * 获取知识库详情
     * @param datasetId
     * @return
     */
    @GetMapping("/{dataset_id}")
    public ApiResponse<DatasetDetailVO> getDataset(@PathVariable("dataset_id") String datasetId) {
        try {
            return ApiResponse.success(llmOpsDatasetService.getDataset(datasetId));
        } catch (IllegalArgumentException ex) {
            return ApiResponse.error(ResponseStatusEnum.VALIDATE_ERROR);
        } catch (Exception ex) {
            return ApiResponse.error(ResponseStatusEnum.SYSTEM_ERROR);
        }
    }

    /**
     * 最近查询记录
     * @param datasetId
     * @return
     */
    @GetMapping("/{dataset_id}/queries")
    public ApiResponse<List<DatasetQueryVO>> getDatasetQueries(@PathVariable("dataset_id") String datasetId) {
        return ApiResponse.success(llmOpsDatasetService.getDatasetQueries(datasetId));
    }

    /**
     * 获取知识库下文档分页列表数据
     * @param datasetId
     * @param searchWord
     * @param currentPage
     * @param pageSize
     * @return
     */
    @GetMapping("/{dataset_id}/documents")
    public ApiBasePaginatorResponse<DocumentVO> getDocumentsWithPage(@PathVariable("dataset_id") String datasetId,
                                                                     @RequestParam(value = "search_word", required = false) String searchWord,
                                                                     @RequestParam("current_page") Integer currentPage,
                                                                     @RequestParam("page_size") Integer pageSize) {
        return llmOpsDatasetService.getDocumentsWithPage(datasetId, searchWord, currentPage, pageSize);
    }

    /**
     * 在指定知识库下新增文档
     * @param datasetId
     * @param param
     * @return
     */
    @PostMapping("/{dataset_id}/documents")
    public ApiResponse<CreatedDocumentsVO> createDocuments(@PathVariable("dataset_id") String datasetId,
                                         @RequestBody CreateDocumentsParam param) {
        return ApiResponse.success(llmOpsDatasetService.createDocuments(datasetId, param));
    }

    /**
     * 根据批处理标识获取处理进度
     * @param datasetId
     * @param batch
     * @return
     */
    @PostMapping("/{dataset_id}/documents/batch:{batch}")
    public ApiResponse<DocumentBatchVO> getBatchProgress(@PathVariable("dataset_id") String datasetId,
                                              @PathVariable("batch") String batch) {
        return ApiResponse.success(null);
    }

    /**
     * 更新文档基础信息
     * @param datasetId
     * @param documentId
     * @param param
     * @return
     */
    @PostMapping("/{dataset_id}/documents/{document_id}")
    public ApiResponse<Void> updateDocument(@PathVariable("dataset_id") String datasetId,
                                                @PathVariable("document_id") String documentId,
                                                @RequestBody UpdateDocumentNameParam param) {
        llmOpsDatasetService.updateDocument(datasetId, documentId, param);
        return ApiResponse.success(null);
    }

    /**
     * 更改指定文档的启用状态
     * @param datasetId
     * @param documentId
     * @param param
     * @return
     */
    @PostMapping("/{dataset_id}/documents/{document_id}/enabled")
    public ApiResponse<Void> updateDocumentEnabled(@PathVariable("dataset_id") String datasetId,
                                                   @PathVariable("document_id") String documentId,
                                                   @RequestBody UpdateDocumentEnabledParam param) {
        llmOpsDatasetService.updateDocumentEnabled(datasetId, documentId, param);
        return ApiResponse.success(null);
    }

    /**
     * 获取指定文档详情
     * @param datasetId
     * @param documentId
     * @return
     */
    @GetMapping("/{dataset_id}/documents/{document_id}")
    public ApiResponse<DocumentDetailVO> getDocument(@PathVariable("dataset_id") String datasetId,
                                                     @PathVariable("document_id") String documentId) {
        return ApiResponse.success(llmOpsDatasetService.getDocument(datasetId, documentId));
    }

    /**
     * 删除指定文档消息
     * @param datasetId
     * @param documentId
     * @return
     */
    @PostMapping("/{dataset_id}/documents/{document_id}/delete")
    public ApiResponse<Void> deleteDocument(@PathVariable("dataset_id") String datasetId,
                                            @PathVariable("document_id") String documentId) {
        llmOpsDatasetService.deleteDocument(datasetId, documentId);
        return ApiResponse.success(null);
    }

    /**
     * 获取制定文档的片段列表
     * @param datasetId
     * @param documentId
     * @param searchWord
     * @param currentPage
     * @param pageSize
     * @return
     */
    @GetMapping("/{dataset_id}/documents/{document_id}/segments")
    public ApiBasePaginatorResponse<SegmentVO> getSegmentsWithPage(@PathVariable("dataset_id") String datasetId,
                                                                   @PathVariable("document_id") String documentId,
                                                                   @RequestParam(value = "search_word", required = false) String searchWord,
                                                                   @RequestParam("current_page") Integer currentPage,
                                                                   @RequestParam("page_size") Integer pageSize) {
        return llmOpsDatasetService.getSegmentsWithPage(datasetId, documentId, searchWord, currentPage, pageSize);
    }

    /**
     * 新增文档片段信息
     * @param datasetId
     * @param documentId
     * @param param
     * @return
     */
    @PostMapping("/{dataset_id}/documents/{document_id}/segments")
    public ApiResponse<Void> createSegment(@PathVariable("dataset_id") String datasetId,
                                           @PathVariable("document_id") String documentId,
                                           @RequestBody CreateSegmentParam param) {
        llmOpsDatasetService.createSegment(datasetId, documentId, param);
        return ApiResponse.success(null);
    }

    /**
     * 删除对应的文档片段信息
     * @param datasetId
     * @param documentId
     * @param segmentId
     * @return
     */
    @PostMapping("/{dataset_id}/documents/{document_id}/segments/{segment_id}/delete")
    public ApiResponse<Void> deleteSegment(@PathVariable("dataset_id") String datasetId,
                                           @PathVariable("document_id") String documentId,
                                           @PathVariable("segment_id") String segmentId) {
        llmOpsDatasetService.deleteSegment(datasetId, documentId, segmentId);
        return ApiResponse.success(null);
    }

    /**
     * 更新文档片段内容
     * @param datasetId
     * @param documentId
     * @param segmentId
     * @param param
     * @return
     */
    @PostMapping("/{dataset_id}/documents/{document_id}/segments/{segment_id}")
    public ApiResponse<Void> updateSegment(@PathVariable("dataset_id") String datasetId,
                                           @PathVariable("document_id") String documentId,
                                           @PathVariable("segment_id") String segmentId,
                                           @RequestBody UpdateSegmentParam param) {
        llmOpsDatasetService.updateSegment(datasetId, documentId, segmentId, param);
        return ApiResponse.success(null);
    }

    /**
     * 修改文档片段的启用状态
     * @param datasetId
     * @param documentId
     * @param segmentId
     * @param param
     * @return
     */
    @PostMapping("/{dataset_id}/documents/{document_id}/segments/{segment_id}/enabled")
    public ApiResponse<Void> updateSegmentEnabled(@PathVariable("dataset_id") String datasetId,
                                                  @PathVariable("document_id") String documentId,
                                                  @PathVariable("segment_id") String segmentId,
                                                  @RequestBody UpdateSegmentEnabledParam param) {
        llmOpsDatasetService.updateSegmentEnabled(datasetId, documentId, segmentId, param);
        return ApiResponse.success(null);
    }

    /**
     * 查询片段详情
     * @param datasetId
     * @param documentId
     * @param segmentId
     * @return
     */
    @GetMapping("/{dataset_id}/documents/{document_id}/segments/{segment_id}")
    public ApiResponse<SegmentDetailVO> getSegment(@PathVariable("dataset_id") String datasetId,
                                                   @PathVariable("document_id") String documentId,
                                                   @PathVariable("segment_id") String segmentId) {
        return ApiResponse.success(llmOpsDatasetService.getSegment(datasetId, documentId, segmentId));
    }
}

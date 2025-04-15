package com.emcikem.llm.web.controller;

import com.emcikem.llm.common.entity.ApiBasePaginatorResponse;
import com.emcikem.llm.common.entity.ApiResponse;
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
 * @Description: 知识库接口
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

        return llmOpsDatasetService.getDatasetsWithPage(searchWord, currentPage, pageSize);
    }

    /**
     * 获取知识库详情
     * @param datasetId
     * @return
     */
    @GetMapping("/{dataset_id}")
    public ApiResponse<DatasetDetailVO> getDataset(@PathVariable("dataset_id") String datasetId) {
        return ApiResponse.success(llmOpsDatasetService.getDataset(datasetId));
    }

    /**
     * 新增知识库
     * @param createDatasetParam
     * @return
     */
    @PostMapping
    public ApiResponse<Void> createDataset(@RequestBody CreateDatasetParam createDatasetParam) {
        llmOpsDatasetService.createDataset(createDatasetParam);
        return ApiResponse.success(null);
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
        llmOpsDatasetService.updateDataset(datasetId, updateDatasetParam);
        return ApiResponse.success(null);
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
     * 获取文档分页列表数据
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

    @PostMapping("/{dataset_id}/documents")
    public ApiResponse<CreatedDocumentsVO> createDocuments(@PathVariable("dataset_id") String datasetId,
                                         @RequestBody CreateDocumentsParam param) {
        return ApiResponse.success(llmOpsDatasetService.createDocuments(datasetId, param));
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
     * 更新文档名字
     * @param datasetId
     * @param documentId
     * @param param
     * @return
     */
    @PostMapping("/{dataset_id}/documents/{document_id}")
    public ApiResponse<Void> updateDocumentName(@PathVariable("dataset_id") String datasetId,
                                                @PathVariable("document_id") String documentId,
                                                @RequestBody UpdateDocumentNameParam param) {
        llmOpsDatasetService.updateDocumentName(datasetId, documentId, param);
        return ApiResponse.success(null);
    }

    /**
     * 片段列表
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
     * 片段详情
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

    @PostMapping("/{dataset_id}/documents/{document_id}/segments/{segment_id}/enabled")
    public ApiResponse<Void> updateSegmentEnabled(@PathVariable("dataset_id") String datasetId,
                                                  @PathVariable("document_id") String documentId,
                                                  @PathVariable("segment_id") String segmentId,
                                                  @RequestBody UpdateSegmentEnabledParam param) {
        llmOpsDatasetService.updateSegmentEnabled(datasetId, documentId, segmentId, param);
        return ApiResponse.success(null);
    }

    @PostMapping("/{dataset_id}/documents/{document_id}/segments/{segment_id}/delete")
    public ApiResponse<Void> deleteSegment(@PathVariable("dataset_id") String datasetId,
                                           @PathVariable("document_id") String documentId,
                                           @PathVariable("segment_id") String segmentId) {
        llmOpsDatasetService.deleteSegment(datasetId, documentId, segmentId);
        return ApiResponse.success(null);
    }

    @PostMapping("/{dataset_id}/documents/{document_id}/segments")
    public ApiResponse<Void> createSegment(@PathVariable("dataset_id") String datasetId,
                                           @PathVariable("document_id") String documentId,
                                           @RequestBody CreateSegmentParam param) {
        llmOpsDatasetService.createSegment(datasetId, documentId, param);
        return ApiResponse.success(null);
    }

    @PostMapping("/{dataset_id}/documents/{document_id}/segments/{segment_id}")
    public ApiResponse<Void> createSegment(@PathVariable("dataset_id") String datasetId,
                                           @PathVariable("document_id") String documentId,
                                           @PathVariable("segment_id") String segmentId,
                                           @RequestBody CreateSegmentParam param) {
        llmOpsDatasetService.updateSegment(datasetId, documentId, segmentId, param);
        return ApiResponse.success(null);
    }
}

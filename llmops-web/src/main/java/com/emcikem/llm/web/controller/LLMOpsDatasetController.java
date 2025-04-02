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

    @GetMapping
    public ApiBasePaginatorResponse<DatasetVO> getDatasetsWithPage(@RequestParam(value = "search_word", required = false) String searchWord,
                                                                   @RequestParam("current_page") Integer currentPage,
                                                                   @RequestParam("page_size") Integer pageSize) {

        return llmOpsDatasetService.getDatasetsWithPage(searchWord, currentPage, pageSize);
    }

    @GetMapping("/{dataset_id}")
    public ApiResponse<DatasetDetailVO> getDataset(@PathVariable("dataset_id") String datasetId) {
        return ApiResponse.success(llmOpsDatasetService.getDataset(datasetId));
    }

    @PostMapping("/create")
    public ApiResponse<Void> createDataset(@RequestBody CreateDatasetParam createDatasetParam) {
        llmOpsDatasetService.createDataset(createDatasetParam);
        return ApiResponse.success(null);
    }

    @PostMapping("/{dataset_id}")
    public ApiResponse<Void> updateDataset(@PathVariable("dataset_id") String datasetId,
                                           @RequestBody UpdateDatasetParam updateDatasetParam) {
        llmOpsDatasetService.updateDataset(datasetId, updateDatasetParam);
        return ApiResponse.success(null);
    }

    @GetMapping("/{dataset_id}/queries")
    public ApiResponse<List<DatasetQueryVO>> getDatasetQueries(@PathVariable("dataset_id") String datasetId) {
        return ApiResponse.success(llmOpsDatasetService.getDatasetQueries(datasetId));
    }

    @PostMapping("/{dataset_id}/delete")
    public ApiResponse<Void> deleteDataset(@PathVariable("dataset_id") String datasetId) {
        llmOpsDatasetService.deleteDataset(datasetId);
        return ApiResponse.success(null);
    }
}

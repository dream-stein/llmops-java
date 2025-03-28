package com.emcikem.llm.web.controller;

import com.emcikem.llm.common.entity.ApiBasePaginatorResponse;
import com.emcikem.llm.common.entity.ApiResponse;
import com.emcikem.llm.common.vo.dataset.CreateDatasetDetailVO;
import com.emcikem.llm.common.vo.dataset.DatasetVO;
import com.emcikem.llm.service.service.dataset.LLMOpsDatasetService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/create")
    public ApiResponse<Void> createDataset(@RequestBody CreateDatasetDetailVO createDatasetDetailVO) {
        return ApiResponse.success(null);
    }

    @PostMapping("/update")
    public ApiResponse<Void> updateDataset() {
        return ApiResponse.success(null);
    }
}

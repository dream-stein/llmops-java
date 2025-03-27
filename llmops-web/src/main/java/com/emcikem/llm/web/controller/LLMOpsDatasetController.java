package com.emcikem.llm.web.controller;

import com.emcikem.llm.common.entity.ApiResponse;
import com.emcikem.llm.common.vo.dataset.CreateDatasetDetailVO;
import com.emcikem.llm.common.vo.dataset.DatasetListVO;
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

    @GetMapping("/list")
    public ApiResponse<DatasetListVO> list(String search_word, Integer current_page, Integer page_size) {
        DatasetListVO listVO = new DatasetListVO();

        return ApiResponse.success(listVO);
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

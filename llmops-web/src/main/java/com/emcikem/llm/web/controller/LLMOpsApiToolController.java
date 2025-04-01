package com.emcikem.llm.web.controller;

import com.emcikem.llm.common.entity.ApiBasePaginatorResponse;
import com.emcikem.llm.common.entity.ApiResponse;
import com.emcikem.llm.common.vo.tools.*;
import com.emcikem.llm.dao.entity.LlmOpsApiToolProviderDO;
import com.emcikem.llm.dao.example.LlmOpsApiToolProviderDOExample;
import com.emcikem.llm.dao.mapper.LlmOpsApiToolProviderDOMapper;
import com.emcikem.llm.service.service.apitool.LLMOpsApiToolService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.UUID;

/**
 * Create with Emcikem on 2025/3/2
 *
 * @author Emcikem
 * @version 1.0.0
 * @description 插件
 */
@RestController
@RequestMapping("/api-tools")
public class LLMOpsApiToolController {

    @Resource
    private LlmOpsApiToolProviderDOMapper llmOpsApiToolProviderDOMapper;

    @Resource
    private LLMOpsApiToolService llmOpsApiToolService;

    @GetMapping("/list")
    public ApiBasePaginatorResponse<ApiToolProviderVO> getApiToolProvidersWithPage(@RequestParam("search_word") String searchWord,
                                                                                   @RequestParam("current_page") Integer currentPage,
                                                                                   @RequestParam("page_size") Integer pageSize) {
        return llmOpsApiToolService.getApiToolProvidersWithPage(searchWord, currentPage, pageSize);
    }

    @PostMapping("/validate-openapi-schema")
    public ApiResponse<Void> validateOpenAPISchema(@RequestBody ApiValidateOpenApiSchemaVO schemaVO) {
        return ApiResponse.success(null);
    }

    @PostMapping("/create")
    public ApiResponse<Void> createApiToolProvider(@RequestBody CreateProviderDetailVO createProviderDetailVO) {
        return ApiResponse.success(null);
    }

    @PostMapping("/update/{provider_id}")
    public ApiResponse<Void> updateApiToolProvider(@PathVariable String provider_id, @RequestBody UpdateProviderDetailVO updateProviderDetailVO) {
        return ApiResponse.success(null);
    }

    @PostMapping("/{provider_id}/delete")
    public ApiResponse<Void> deleteApiToolProvider(@PathVariable String provider_id) {
        return ApiResponse.success(null);
    }

    @PostMapping("/detail/{provider_id}")
    public ApiResponse<GetApiToolProviderVO> getApiToolProvider(@PathVariable String provider_id) {
        return ApiResponse.success(null);
    }

    @GetMapping("/{provider_id}/{tool_name}")
    public ApiResponse<GetApiToolVO> getApiTool(@PathVariable String provider_id, @PathVariable String tool_name) {
        return ApiResponse.success(null);
    }
}

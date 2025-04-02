package com.emcikem.llm.web.controller;

import com.emcikem.llm.common.entity.ApiBasePaginatorResponse;
import com.emcikem.llm.common.entity.ApiResponse;
import com.emcikem.llm.common.vo.tools.*;
import com.emcikem.llm.service.service.apitool.LLMOpsApiToolProviderService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;


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
    private LLMOpsApiToolProviderService llmOpsApiToolProviderService;

    @GetMapping("/list")
    public ApiBasePaginatorResponse<ApiToolProviderVO> getApiToolProvidersWithPage(@RequestParam("search_word") String searchWord,
                                                                                   @RequestParam("current_page") Integer currentPage,
                                                                                   @RequestParam("page_size") Integer pageSize) {
        return llmOpsApiToolProviderService.getApiToolProvidersWithPage(searchWord, currentPage, pageSize);
    }

    @PostMapping("/validate-openapi-schema")
    public ApiResponse<Void> validateOpenAPISchema(@RequestBody ApiValidateOpenApiSchemaVO schemaVO) {
        return ApiResponse.success(null);
    }

    @PostMapping("/create")
    public ApiResponse<Void> createApiToolProvider(@RequestBody CreateToolProviderParam createToolProviderParam) {
        llmOpsApiToolProviderService.createApiToolProvider(createToolProviderParam);
        return ApiResponse.success(null);
    }

    @PostMapping("/update/{provider_id}")
    public ApiResponse<Void> updateApiToolProvider(@PathVariable("provider_id") String providerId,
                                                   @RequestBody UpdateProviderParam updateProviderParam) {
        llmOpsApiToolProviderService.updateApiToolProvider(providerId, updateProviderParam);
        return ApiResponse.success(null);
    }

    @PostMapping("/{provider_id}/delete")
    public ApiResponse<Void> deleteApiToolProvider(@PathVariable("provider_id") String providerId) {
        llmOpsApiToolProviderService.deleteApiToolProvider(providerId);
        return ApiResponse.success(null);
    }

    @GetMapping("/detail/{provider_id}")
    public ApiResponse<ApiToolProviderDetailVO> getApiToolProvider(@PathVariable("provider_id") String providerId) {
        return ApiResponse.success(llmOpsApiToolProviderService.getApiToolProvider(providerId));
    }
}

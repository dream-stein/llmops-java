package com.emcikem.llm.web.controller;

import com.emcikem.llm.common.entity.ApiBasePaginatorRequest;
import com.emcikem.llm.common.entity.ApiBasePaginatorResponse;
import com.emcikem.llm.common.entity.ApiResponse;
import com.emcikem.llm.common.vo.apikey.ApiKeysPageVO;
import com.emcikem.llm.common.vo.apikey.CreateApiKeyParam;
import com.emcikem.llm.common.vo.apikey.UpdateApiKeyIsActiveParam;
import com.emcikem.llm.common.vo.apikey.UpdateApiKeyParam;
import com.emcikem.llm.service.service.apikey.LLMOpsApiKeyService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

/**
 * Create with Emcikem on 2025/3/28
 *
 * @author Emcikem
 * @version 1.0.0
 */
@RestController
@RequestMapping("/openapi/api-keys")
public class LLMOpsApiKeyController {

    @Resource
    private LLMOpsApiKeyService llmOpsApiKeyService;

    @PostMapping
    public ApiResponse<Void> createApiKey(@RequestBody CreateApiKeyParam param) {
        llmOpsApiKeyService.createApiKey(param);
        return ApiResponse.success(null);
    }

    @PostMapping("/{api_key_id}/delete")
    public ApiResponse<Void> deleteApiKey(@PathVariable("api_key_id") String apiKeyId) {
        llmOpsApiKeyService.deleteApiKey(apiKeyId);
        return ApiResponse.success(null);
    }

    @PostMapping("/{api_key_id}")
    public ApiResponse<Void> updateApiKey(@PathVariable("api_key_id") String apiKeyId, @RequestBody UpdateApiKeyParam param) {
        llmOpsApiKeyService.updateApiKey(apiKeyId, param);
        return ApiResponse.success(null);
    }

    @PostMapping("/{api_key_id}/is-active")
    public ApiResponse<Void> updateApiKeyIsActive(@PathVariable("api_key_id") String apiKeyId, @RequestBody UpdateApiKeyIsActiveParam param) {
        llmOpsApiKeyService.updateApiKeyIsActive(apiKeyId, param);
        return ApiResponse.success(null);
    }

    @GetMapping
    public ApiBasePaginatorResponse<ApiKeysPageVO> getApiKeysWithPage(@RequestParam("current_page") Integer currentPage,
                                                                      @RequestParam("page_size") Integer pageSize) {
        ApiBasePaginatorRequest request = new ApiBasePaginatorRequest();
        request.setCurrent_page(currentPage);
        request.setPage_size(pageSize);
        return llmOpsApiKeyService.getAPiKeysWithPage(request);
    }
}

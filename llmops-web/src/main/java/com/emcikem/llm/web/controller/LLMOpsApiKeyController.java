package com.emcikem.llm.web.controller;

import com.emcikem.llm.common.entity.ApiBasePaginatorRequest;
import com.emcikem.llm.common.entity.ApiBasePaginatorResponse;
import com.emcikem.llm.common.entity.ApiResponse;
import com.emcikem.llm.common.vo.apikey.ApiKeysPageVO;
import com.emcikem.llm.common.vo.apikey.CreateApiKeyParam;
import com.emcikem.llm.common.vo.apikey.UpdateApiKeyIsActiveParam;
import com.emcikem.llm.common.vo.apikey.UpdateApiKeyParam;
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

    @PostMapping
    public ApiResponse<Void> createApiKey(@RequestBody CreateApiKeyParam param) {
        return ApiResponse.success(null);
    }

    @PostMapping("/{api_key_id}/delete")
    public ApiResponse<Void> deleteApiKey(@PathVariable("api_key_id") String apiKeyId) {
        return ApiResponse.success(null);
    }

    @PostMapping("/{api_key_id}")
    public ApiResponse<Void> updateApiKey(@PathVariable("api_key_id") String apiKeyId, @RequestBody UpdateApiKeyParam param) {
        return ApiResponse.success(null);
    }

    @PostMapping("/{api_key_id}/is-active")
    public ApiResponse<Void> isActive(@PathVariable("api_key_id") String apiKeyId, @RequestBody UpdateApiKeyIsActiveParam param) {
        return ApiResponse.success(null);
    }

    @GetMapping
    public ApiBasePaginatorResponse<ApiKeysPageVO> getApiKeysWithPage(@RequestBody ApiBasePaginatorRequest request) {
        return ApiBasePaginatorResponse.success(null, null);
    }
}

package com.emcikem.llm.web.controller;

import com.emcikem.llm.common.entity.ApiResponse;
import com.google.protobuf.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create with Emcikem on 2025/3/28
 *
 * @author Emcikem
 * @version 1.0.0
 */
@RestController
@RequestMapping("/language-models")
public class LLMOpsLanguageModelController {

    /**
     * 获取所有语言模型列表信息
     * @return
     */
    @GetMapping
    public ApiResponse<Void> getLanguageModels() {
        return ApiResponse.success(null);
    }

    /**
     * 获取指定模型的详细信息
     * @return
     */
    @GetMapping("/{provider_name}/{model_name}")
    public ApiResponse<Void> getLanguageModel() {
        return ApiResponse.success(null);
    }
}

package com.emcikem.llm.web.controller;

import com.emcikem.llm.common.entity.ApiResponse;
import com.emcikem.llm.common.vo.builtintool.GetBuiltinToolVO;
import com.emcikem.llm.common.vo.builtintool.GetCategoryVO;
import com.emcikem.llm.common.vo.tools.ApiProviderToolVO;
import com.emcikem.llm.common.vo.tools.ApiToolProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Create with Emcikem on 2025/3/28
 *
 * @author Emcikem
 * @version 1.0.0
 */
@RestController
@RequestMapping("/builtin-tools")
public class LLMOpsBuiltinToolController {

    @GetMapping("/categories")
    public ApiResponse<List<GetCategoryVO>> getCategories() {
        return ApiResponse.success(null);
    }

    @GetMapping()
    public ApiResponse<GetBuiltinToolVO> getBuiltinTools() {
        return ApiResponse.success(null);
    }

    // todo: 模型修改
    @GetMapping("/{provider_name}/tools/{tool_name}")
    public ApiResponse<Void> getBuiltinTool(@PathVariable String provider_name, @PathVariable String tool_name) {
        return ApiResponse.success(null);
    }
}

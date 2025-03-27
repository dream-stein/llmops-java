package com.emcikem.llm.web.controller;

import com.emcikem.llm.common.entity.ApiResponse;
import com.emcikem.llm.common.vo.builtinapp.AddBuiltinAppToSpaceVO;
import com.emcikem.llm.common.vo.builtinapp.GetBuiltinAppCategoriesVO;
import com.emcikem.llm.common.vo.builtinapp.GetBuiltinAppsVO;
import com.emcikem.llm.common.vo.builtinapp.AddBuiltinAppToSpaceParam;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Create with Emcikem on 2025/3/28
 *
 * @author Emcikem
 * @version 1.0.0
 */
@RestController
@RequestMapping("/builtin-apps")
public class LLMOpsBuiltinAppController {

    @GetMapping("/categories")
    public ApiResponse<List<GetBuiltinAppCategoriesVO>> getBuiltinAppCategories() {
        return ApiResponse.success(null);
    }

    @GetMapping
    public ApiResponse<GetBuiltinAppsVO> getBuiltinApps() {
        return ApiResponse.success(null);
    }

    @PostMapping("/add-builtin-app-to-space")
    public ApiResponse<AddBuiltinAppToSpaceVO> addBuiltinAppToSpace(@RequestBody AddBuiltinAppToSpaceParam param) {
        return ApiResponse.success(null);
    }
}

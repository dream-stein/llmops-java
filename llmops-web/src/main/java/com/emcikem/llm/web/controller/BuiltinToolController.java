package com.emcikem.llm.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create with Emcikem on {DATE}
 *
 * @author Emcikem
 * @version 1.0.0
 */
@RestController
public class BuiltinToolController {

    /**
     * 获取所有的内置插件
     */
    @GetMapping("/builtin/tools")
    public void getBuiltinTools() {

    }

    /**
     * 获取插件详情
     */
    @GetMapping("/builtin/detail")
    public void getBuiltinToolDetail(String providerName, String toolName) {

    }
}

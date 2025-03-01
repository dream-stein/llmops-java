package com.emcikem.llm.service.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Create with Emcikem on {DATE}
 *
 * @author Emcikem
 * @version 1.0.0
 */
@Service
@Slf4j
public class BuiltinToolService {

    /**
     *
     */
    public void getBuiltinTools() {
        // 1. 获取所有的提供商
//        List<>
        // 2. 遍历所有的提供商并提取工具消息

        // 3. 除了工具实体，还需要提取工具的inputs代表大语言模型的输入参数信息

        // 4. 组装所有消息为list，并返回
    }

    /**
     *
     * @param providerName 提供者名字
     * @param toolName 工具名字
     */
    public void getBuiltinToolDetail(String providerName, String toolName) {

    }
}

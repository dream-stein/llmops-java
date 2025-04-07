package com.emcikem.llm.common.vo.apps.config;

import lombok.Data;

/**
 * Create with Emcikem on 2025/4/7
 *
 * @author Emcikem
 * @version 1.0.0
 */
@Data
public class ToolsConfigVO {

    private String type;

    private ToolsProviderConfigVO provider;

    private ToolsToolConfigVO tool;
}

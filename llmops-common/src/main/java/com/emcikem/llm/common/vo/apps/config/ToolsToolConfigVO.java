package com.emcikem.llm.common.vo.apps.config;

import lombok.Data;

import java.util.List;

/**
 * Create with Emcikem on 2025/4/7
 *
 * @author Emcikem
 * @version 1.0.0
 */
@Data
public class ToolsToolConfigVO {

    private String id;

    private String name;

    private String label;

    private String description;

    private List<ToolsToolParamConfigVO> params;
}

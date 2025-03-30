package com.emcikem.llm.common.vo.apps;

import lombok.Data;

/**
 * Create with Emcikem on 2025/3/30
 *
 * @author Emcikem
 * @version 1.0.0
 */
@Data
public class AppVO {

    private String id;

    private String name;

    private String icon;

    private String description;

    private String preset_prompt;

    private ModelConfigVO model_config;

    private String status;

    private Long created_at;

    private Long updated_at;
}

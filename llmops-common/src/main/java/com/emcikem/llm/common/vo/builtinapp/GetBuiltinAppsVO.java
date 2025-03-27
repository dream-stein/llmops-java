package com.emcikem.llm.common.vo.builtinapp;

import lombok.Data;

/**
 * Create with Emcikem on 2025/3/28
 *
 * @author Emcikem
 * @version 1.0.0
 */
@Data
public class GetBuiltinAppsVO {

    private String id;

    private String category;

    private String name;

    private String icon;

    private String description;

    private BuiltinAppsModelConfigVO model_config;

    private Long created_at;
}

package com.emcikem.llm.common.vo.tools;

import lombok.Data;

import java.util.List;

/**
 * Create with Emcikem on 2025/3/28
 *
 * @author Emcikem
 * @version 1.0.0
 */
@Data
public class ApiToolProviderDetailVO {

    private String id;

    private String name;

    private String icon;

    private String openapi_schema;

    private List<ApiToolHeaderVO> headers;

    private Long created_at;
}

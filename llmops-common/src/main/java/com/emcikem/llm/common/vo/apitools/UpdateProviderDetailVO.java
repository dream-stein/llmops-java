package com.emcikem.llm.common.vo.apitools;

import lombok.Data;

import java.util.List;

/**
 * Create with Emcikem on 2025/3/2
 *
 * @author Emcikem
 * @version 1.0.0
 */
@Data
public class UpdateProviderDetailVO {

    private String name;

    private String icon;

    private String openapi_schema;

    private List<ApiToolHeaderVO> headers;
}

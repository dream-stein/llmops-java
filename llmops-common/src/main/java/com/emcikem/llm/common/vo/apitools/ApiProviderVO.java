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
public class ApiProviderVO {

    private String id;

    private String name;

    private String icon;

    private String description;

    private List<ApiProviderToolVO> tools;

    private List<ApiToolHeaderVO> headers;
}

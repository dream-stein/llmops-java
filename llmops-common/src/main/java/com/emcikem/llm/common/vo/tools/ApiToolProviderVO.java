package com.emcikem.llm.common.vo.tools;

import lombok.Data;

import java.util.List;

/**
 * Create with Emcikem on 2025/3/30
 *
 * @author Emcikem
 * @version 1.0.0
 */
@Data
public class ApiToolProviderVO {

    private String id;

    private String name;

    private String icon;

    private String description;

    private List<ApiToolProviderToolVO> tools;

    private List<ApiToolProviderHeaderVO> headers;

    private Long created_at;
}

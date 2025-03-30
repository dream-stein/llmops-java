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
public class ApiToolVO {

    private String id;

    private String name;

    private String icon;

    private String description;

    private List<ApiProviderToolVO> tools;

    private List<ApiToolHeaderVO> headers;

    private Long created_at;
}

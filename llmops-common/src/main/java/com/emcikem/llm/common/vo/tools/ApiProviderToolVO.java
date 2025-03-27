package com.emcikem.llm.common.vo.tools;

import lombok.Data;

import java.util.List;

/**
 * Create with Emcikem on 2025/3/2
 *
 * @author Emcikem
 * @version 1.0.0
 */
@Data
public class ApiProviderToolVO {

    private String id;

    private String description;

    private String name;

    private List<ApiToolInputVO> inputs;
}

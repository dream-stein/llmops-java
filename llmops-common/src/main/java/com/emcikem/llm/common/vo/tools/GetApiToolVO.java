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
public class GetApiToolVO {

    private String id;

    private String name;

    private String description;

    private ApiToolProvider provider;

    private List<ApiToolProviderInputVO> inputs;
}

package com.emcikem.llm.common.vo.apps.config;

import lombok.Data;

import java.util.List;

/**
 * Create with Emcikem on 2025/4/5
 *
 * @author Emcikem
 * @version 1.0.0
 */
@Data
public class ReviewConfigVO {

    private Boolean enable;

    private List<String> keywords;

    private InputsConfigVO inputs_config;

    private OutputsConfigVO outputs_config;
}

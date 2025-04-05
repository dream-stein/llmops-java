package com.emcikem.llm.common.vo.apps.config;

import lombok.Data;

/**
 * Create with Emcikem on 2025/4/5
 *
 * @author Emcikem
 * @version 1.0.0
 */
@Data
public class RetrievalConfigVO {

    private String retrieval_strategy;

    private Integer k;

    private float score;
}

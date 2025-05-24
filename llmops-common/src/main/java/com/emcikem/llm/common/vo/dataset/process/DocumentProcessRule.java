package com.emcikem.llm.common.vo.dataset.process;

import lombok.Data;

import java.util.List;

/**
 * Create with Emcikem on 2025/4/13
 *
 * @author Emcikem
 * @version 1.0.0
 */
@Data
public class DocumentProcessRule {

    private String regex;

    private String separators;

    private Integer chunk_size;

    private Integer chunk_overlap;

    private List<DocumentPreProcessRule> pre_process_rules;
}

package com.emcikem.llm.common.vo.dataset;

import lombok.Data;

import java.util.List;

/**
 * Create with Emcikem on 2025/4/16
 *
 * @author Emcikem
 * @version 1.0.0
 */
@Data
public class CreateDocumentRuleVO {

    private List<CreateDocumentPreProcessRuleVO> pre_process_rules;

    private CreateDocumentSegmentVO segment;
}

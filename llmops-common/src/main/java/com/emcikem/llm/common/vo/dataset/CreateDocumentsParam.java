package com.emcikem.llm.common.vo.dataset;

import lombok.Data;

import java.util.List;

/**
 * Create with Emcikem on 2025/4/15
 *
 * @author Emcikem
 * @version 1.0.0
 */
@Data
public class CreateDocumentsParam {

    private List<String> upload_file_ids;

    private String process_type;

    private CreateDocumentRuleVO rule;
}

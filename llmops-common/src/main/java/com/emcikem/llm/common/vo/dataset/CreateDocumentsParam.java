package com.emcikem.llm.common.vo.dataset;

import lombok.Data;

import java.util.List;

/**
 * Create with Emcikem on 2025/4/15
 *
 * @author Emcikem
 * @version 1.0.0
 * {
 *   "upload_file_ids": [
 *     "1a310cfa-d5aa-43f5-bd4a-a37283866cdd"
 *   ],
 *   "process_type": "custom",
 *   "rule": {
 *     "pre_process_rules": [
 *       {
 *         "id": "remove_extra_space",
 *         "enabled": true
 *       },
 *       {
 *         "id": "remove_url_and_email",
 *         "enabled": true
 *       }
 *     ],
 *     "segment": {
 *       "separators": [
 *         "\n"
 *       ],
 *       "chunk_size": 500,
 *       "chunk_overlap": 50
 *     }
 *   }
 * }
 */
@Data
public class CreateDocumentsParam {

    private List<String> upload_file_ids;

    private String process_type;

    private CreateDocumentRuleVO rule;
}

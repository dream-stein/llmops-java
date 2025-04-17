package com.emcikem.llm.common.vo.dataset;

import lombok.Data;

/**
 * Create with Emcikem on 2025/4/16
 *
 * @author Emcikem
 * @version 1.0.0
 */
@Data
public class CreateDocumentPreProcessRuleVO {

    /**
     * remove_extra_space
     * remove_url_and_email
     */
    private String id;

    private Boolean enabled;
}

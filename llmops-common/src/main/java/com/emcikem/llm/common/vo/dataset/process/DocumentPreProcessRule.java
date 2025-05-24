package com.emcikem.llm.common.vo.dataset.process;

import lombok.Data;

/**
 * Create with Emcikem on 2025/5/24
 *
 * @author Emcikem
 * @version 1.0.0
 */
@Data
public class DocumentPreProcessRule {

    /**
     * remove_extra_space
     * remove_url_and_email
     */
    private String id;

    private Boolean enabled;
}

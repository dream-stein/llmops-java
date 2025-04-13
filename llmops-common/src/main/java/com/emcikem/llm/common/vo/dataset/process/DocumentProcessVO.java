package com.emcikem.llm.common.vo.dataset.process;

import lombok.Data;

/**
 * Create with Emcikem on 2025/4/13
 *
 * @author Emcikem
 * @version 1.0.0
 */
@Data
public class DocumentProcessVO {

    private String processType;

    private DocumentProcessRule rule;
}

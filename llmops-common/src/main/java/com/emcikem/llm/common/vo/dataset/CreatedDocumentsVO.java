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
public class CreatedDocumentsVO {

    private String batch;

    private List<DocumentVO> document;
}

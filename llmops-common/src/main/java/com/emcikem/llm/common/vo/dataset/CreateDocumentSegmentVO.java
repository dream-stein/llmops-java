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
public class CreateDocumentSegmentVO {

    private List<String> separators;

    private Long chunk_size;

    private Long chunk_overlap;
}

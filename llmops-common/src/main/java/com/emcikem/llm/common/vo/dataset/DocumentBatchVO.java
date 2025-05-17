package com.emcikem.llm.common.vo.dataset;

import lombok.Data;

/**
 * Create with Emcikem on 2025/5/17
 *
 * @author Emcikem
 * @version 1.0.0
 */
@Data
public class DocumentBatchVO {

    private String id;

    private Integer segment_count;

    private Integer completed_segment_count;

    private String error;

    private String status;

    private Long processing_started_at;

    private Long parsing_completed_at;

    private Long splitting_completed_at;

    private Long completed_at;

}

package com.emcikem.llm.common.vo.dataset;

import lombok.Data;

import java.util.List;

/**
 * Create with Emcikem on 2025/4/5
 *
 * @author Emcikem
 * @version 1.0.0
 */
@Data
public class SegmentDetailVO {

    private String id;

    private String document_id;

    private String dataset_id;

    private Integer position;

    private String content;

    private List<String> keywords;

    private Integer character_count;

    private Integer token_count;

    private Integer hit_count;

    private String hash;

    private Boolean enabled;

    private String status;

    private String error;

    private Long created_at;

    private Long updated_at;
}

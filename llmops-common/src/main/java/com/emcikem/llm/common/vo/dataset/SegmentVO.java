package com.emcikem.llm.common.vo.dataset;

import lombok.Data;

import java.util.List;

/**
 * Create with Emcikem on 2025/4/3
 *
 * @author Emcikem
 * @version 1.0.0
 */
@Data
public class SegmentVO {

    private String id;

    private String dataset_id;

    private String document_id;

    private Integer position;

    private String content;

    private List<String> keywords;

    private Integer character_count;

    private Integer token_count;

    private Integer hit_count;

    private Boolean enabled;

    private Long disabled_at;

    private String status;

    private String error;

    private Long created_at;

    private Long updated_at;
}

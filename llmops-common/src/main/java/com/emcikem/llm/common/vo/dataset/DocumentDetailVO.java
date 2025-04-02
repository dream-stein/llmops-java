package com.emcikem.llm.common.vo.dataset;

import lombok.Data;

/**
 * Create with Emcikem on 2025/4/2
 *
 * @author Emcikem
 * @version 1.0.0
 */
@Data
public class DocumentDetailVO {

    private String id;

    private String dataset_id;

    private String name;

    private Integer segment_count;

    private Integer character_count;

    private Integer hit_count;

    private Integer position;

    private Boolean enabled;

    private Long disabled_at;

    private String status;

    private String error;

    private Long created_at;

    private Long updated_at;
}

package com.emcikem.llm.common.vo.dataset;

import lombok.Data;

/**
 * Create with Emcikem on 2025/3/14
 *
 * @author Emcikem
 * @version 1.0.0
 */
@Data
public class DatasetVO {

    private String id;

    private String name;

    private String icon;

    private String description;

    private Integer document_count;

    private Integer character_count;

    private Integer related_app_count;

    private Long updated_at;

    private Long created_at;
}

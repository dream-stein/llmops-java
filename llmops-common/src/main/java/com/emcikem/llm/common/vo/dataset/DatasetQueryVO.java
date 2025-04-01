package com.emcikem.llm.common.vo.dataset;

import lombok.Data;

/**
 * Create with Emcikem on 2025/4/2
 *
 * @author Emcikem
 * @version 1.0.0
 */
@Data
public class DatasetQueryVO {

    private String id;

    private String query;

    private String source;

    private String dataset_id;

    private Long created_at;
}

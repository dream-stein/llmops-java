package com.emcikem.llm.common.entity;

import lombok.Data;

/**
 * Create with Emcikem on 2025/3/2
 *
 * @author Emcikem
 * @version 1.0.0
 */
@Data
public class Paginator {

    private Integer current_page;

    private Integer page_size;

    private Integer total_page;

    private Integer total_record;
}

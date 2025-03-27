package com.emcikem.llm.common.entity;

import lombok.Data;

/**
 * Create with Emcikem on 2025/3/28
 *
 * @author Emcikem
 * @version 1.0.0
 */
@Data
public class ApiBasePaginatorRequest {

    private Integer current_page;

    private Integer page_size;
}

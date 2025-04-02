package com.emcikem.llm.common.vo.dataset;

import lombok.Data;

/**
 * Create with Emcikem on 2025/4/2
 *
 * @author Emcikem
 * @version 1.0.0
 */
@Data
public class GetDocumentsWithPageParam {

    private String search_word;

    private Integer page_size;

    private Integer current_page;
}

package com.emcikem.llm.common.vo;

import lombok.Data;

/**
 * @author wx40217
 * @date 2025/1/19
 */
@Data
public class ChatHistoryVO {

    private Long userId;

    private Integer page;

    private Integer size;
}

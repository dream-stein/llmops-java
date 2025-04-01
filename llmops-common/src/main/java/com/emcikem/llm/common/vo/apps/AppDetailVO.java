package com.emcikem.llm.common.vo.apps;

import lombok.Data;

/**
 * Create with Emcikem on 2025/4/2
 *
 * @author Emcikem
 * @version 1.0.0
 */
@Data
public class AppDetailVO {

    private String id;

    private String debug_conversation_id;

    private String name;

    private String icon;

    private String description;

    private String status;

    private Long draft_updated_at;

    private Long created_at;

    private Long updated_at;
}

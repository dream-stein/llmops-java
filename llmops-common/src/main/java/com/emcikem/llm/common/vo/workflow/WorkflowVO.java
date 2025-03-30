package com.emcikem.llm.common.vo.workflow;

import lombok.Data;

/**
 * Create with Emcikem on 2025/3/30
 *
 * @author Emcikem
 * @version 1.0.0
 */
@Data
public class WorkflowVO {

    private String id;

    private String name;

    private String tool_call_name;

    private String icon;

    private String description;

    private String status;

    private Boolean is_debug_passed;

    private Integer node_count;

    private Long published_at;

    private Long updated_at;

    private Long created_at;
}

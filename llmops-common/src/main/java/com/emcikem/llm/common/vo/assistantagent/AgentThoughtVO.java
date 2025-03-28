package com.emcikem.llm.common.vo.assistantagent;

import lombok.Data;

import java.util.Map;

/**
 * Create with Emcikem on 2025/3/29
 *
 * @author Emcikem
 * @version 1.0.0
 */
@Data
public class AgentThoughtVO {

    private String id;

    private Integer position;

    private String event;

    private String thought;

    private String observation;

    private String tool;

    private Map<String, String> tool_input;

    private Long latency;

    private Long created_at;
}

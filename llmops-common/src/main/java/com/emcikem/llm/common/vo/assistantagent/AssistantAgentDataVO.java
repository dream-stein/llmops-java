package com.emcikem.llm.common.vo.assistantagent;

import lombok.Data;

/**
 * Create with Emcikem on 2025/4/12
 *
 * @author Emcikem
 * @version 1.0.0
 */
@Data
public class AssistantAgentDataVO {

    private String id;

    private String conversation_id;

    private String task_id;

    private String thought;

    private String observation;

    private String answer;

    private Integer latency;

    private Long created_at;
}

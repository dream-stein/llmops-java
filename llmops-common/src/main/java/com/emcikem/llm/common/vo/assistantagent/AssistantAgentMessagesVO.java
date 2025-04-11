package com.emcikem.llm.common.vo.assistantagent;

import lombok.Data;

import java.util.List;

/**
 * Create with Emcikem on 2025/3/29
 *
 * @author Emcikem
 * @version 1.0.0
 */
@Data
public class AssistantAgentMessagesVO {

    private String id;

    private String conversation_id;

    private String query;

    private String answer;

    private Long total_token_count;

    private Long latency;

    private List<AgentThoughtVO> agent_thoughts;

    private Long created_at;
}

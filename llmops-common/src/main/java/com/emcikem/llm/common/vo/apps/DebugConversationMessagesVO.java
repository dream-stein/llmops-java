package com.emcikem.llm.common.vo.apps;

import com.emcikem.llm.common.vo.assistantagent.AgentThoughtVO;
import lombok.Data;

import java.util.List;

/**
 * Create with Emcikem on 2025/4/5
 *
 * @author Emcikem
 * @version 1.0.0
 */
@Data
public class DebugConversationMessagesVO {

    private String id;

    private String conversationId;

    private String query;

    private String answer;

    private Integer total_token_count;

    private Integer latency;

    private List<AgentThoughtVO> agent_thoughts;

    private Long created_at;
}

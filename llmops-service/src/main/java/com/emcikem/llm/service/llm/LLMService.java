package com.emcikem.llm.service.llm;

import java.util.List;

/**
 * Create with Emcikem on 2024/11/22
 *
 * @author Emcikem
 * @version 1.0.0
 */
public interface LLMService {

    List<String> askLLM();

    Integer getType();
}

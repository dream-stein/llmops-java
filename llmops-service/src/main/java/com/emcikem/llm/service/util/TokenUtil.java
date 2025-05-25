package com.emcikem.llm.service.util;

import dev.langchain4j.model.openai.OpenAiTokenizer;

/**
 * Create with Emcikem on 2025/5/25
 *
 * @author Emcikem
 * @version 1.0.0
 */
public class TokenUtil {

    public static Integer calculateTokenContent(String text) {
        OpenAiTokenizer tokenizer = new OpenAiTokenizer("gpt-3.5-turbo");
        return tokenizer.estimateTokenCountInText(text);
    }
}

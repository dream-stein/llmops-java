package com.emcikem.controller;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;
import org.springframework.stereotype.Controller;

/**
 * Create with Emcikem on 2024/11/20
 *
 * @author Emcikem
 * @version 1.0.0
 */
@Controller
public class LlmOpsBaseController {

    public void cal() {
        OpenAiService service = new OpenAiService("你的令牌");
        CompletionRequest completionRequest = CompletionRequest.builder()
                .prompt("有人曾经告诉我世界会让我感到挫败")
                .model("babbage-002")
                .echo(true)
                .n(1)
                .build();
        service.createCompletion(completionRequest).getChoices().forEach(System.out::println);
    }
}

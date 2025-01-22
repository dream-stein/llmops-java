package com.emcikem.llm.service.aiservice;

import dev.langchain4j.agent.tool.P;
import dev.langchain4j.agent.tool.Tool;
import org.springframework.stereotype.Component;

import java.time.LocalTime;


@Component
public class AssistantTools {

    /**
     * This tool is available to {@link Assistant}
     */
    @Tool
    String currentTime() {
        return LocalTime.now().toString();
    }
    @Tool("获取城市的天气")
    String GetWhetherTool(@P("城市名") String city) {
        return "今天有龙卷风";
    }
    @Tool("四则运算")
    String calculate(@P("表达式") String expression) {
        try {
            return String.valueOf(new javax.script.ScriptEngineManager().getEngineByName("JavaScript").eval(expression));
        } catch (Exception e) {
            return "计算失败: " + e.getMessage();
        }
    }

}

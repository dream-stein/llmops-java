package com.emcikem.llm.service.aiservice;

import dev.langchain4j.agent.tool.P;
import dev.langchain4j.agent.tool.Tool;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalTime;

@Slf4j
@Component
public class AssistantTools {

    /**
     * This tool is available to {@link Assistant}
     */
    @Resource
    private RestTemplate restTemplate;
    @Tool
    String currentTime() {
        return LocalTime.now().toString();
    }
    @Tool("获取城市的天气")
    String GetWhetherTool(@P("城市名") String city) {
        return "今天有龙卷风";
    }
    @Tool("运算给定数学表达式")
    String calculate(@P("表达式") String expression) {
        try {
            return String.valueOf(new javax.script.ScriptEngineManager().getEngineByName("JavaScript").eval(expression));
        } catch (Exception e) {
            return "计算失败: " + e.getMessage();
        }
    }
//    @Tool("请求并返回网页内容")
//    String fetchWebContent(@P("链接") String url) {
//        try {
//            return restTemplate.getForObject(url, String.class);
//        } catch (Exception e) {
//            log.error("请求失败: {}", e.getMessage());
//            return e.getMessage();
//        }
//    }


}

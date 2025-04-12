package com.emcikem.llm.service.aiservice.tools;

import com.emcikem.llm.service.aiservice.tools.crawler.WeiBoCrawler;
import dev.langchain4j.agent.tool.P;
import dev.langchain4j.agent.tool.Tool;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
public class AssistantTools {

    @Resource
    private AiToolsWebService aiToolsWebService;

    @Tool("获取当前时间")
    String currentTime() {
        return new Date().toString();
    }

    @Tool("获取当前时间戳")
    Long getCurrentTime() {
        return System.currentTimeMillis();
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

    @Tool("获取微博热搜")
    String crawlWeiboTops() {
        log.info("begin search weibo tops");
        String weiboTos = WeiBoCrawler.crawlWeiboTops();
        log.info("end search weibo tops, tops:{}", weiboTos);
        return weiboTos;
    }

    @Tool("请求并返回网页内容")
    String fetchWebContent(@P("链接") String url) {
        return aiToolsWebService.getWebContent(url);
    }
}

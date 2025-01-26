package com.emcikem.llm.service.aiservice;

import dev.langchain4j.agent.tool.P;
import dev.langchain4j.agent.tool.Tool;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
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
    @Tool("请求并返回网页内容")
    String fetchWebContent(@P("链接") String url) {
        // 获取原始HTML内容
        String htmlContent = restTemplate.getForObject(url, String.class);

        // 使用Jsoup解析文档
        Document doc = Jsoup.parse(htmlContent);

        // 提取页面标题
        String pageTitle = doc.title();

        // 清理无关内容
        doc.select("script, style, noscript, img, nav, footer, aside, button, iframe").remove();

        // 构建正文内容
        StringBuilder content = new StringBuilder();
        for (Element element : doc.select("p, h1, h2, h3, h4, h5, h6, article")) {
            String text = element.text().trim();
            if (!text.isEmpty()) {
                content.append(text).append("\n\n");
            }
        }

        return String.format("%s\n\n%s",
                pageTitle,
                content.toString().replaceAll("\n{3,}", "\n\n").trim()
        );
    }


}

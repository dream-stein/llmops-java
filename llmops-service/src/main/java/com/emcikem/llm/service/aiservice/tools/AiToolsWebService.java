package com.emcikem.llm.service.aiservice.tools;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Create with Emcikem on 2025/4/13
 *
 * @author Emcikem
 * @version 1.0.0
 */
@Service
@Slf4j
public class AiToolsWebService {

    @Resource
    private RestTemplate restTemplate;

    public String getWebContent(String url) {
        try {
            // 设置请求头和超时
            org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
            headers.set("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36");

            org.springframework.http.HttpEntity<String> entity = new org.springframework.http.HttpEntity<>(headers);
            org.springframework.http.ResponseEntity<String> response = restTemplate.exchange(
                    url,
                    org.springframework.http.HttpMethod.GET,
                    entity,
                    String.class
            );

            String htmlContent = response.getBody();
            if (htmlContent == null || htmlContent.trim().isEmpty()) {
                return "无法获取页面内容";
            }

            // 使用Jsoup解析文档
            Document doc = Jsoup.parse(htmlContent);
            doc.select("script, style, noscript, iframe, .advertisement").remove();

            // 提取页面标题
            String pageTitle = doc.title();

            // 构建正文内容
            StringBuilder content = new StringBuilder();

            // 扩大选择器范围，包含更多可能的内容容器
            String[] selectors = {
                    "article", "main", ".content", ".article", ".post",
                    "p", "h1", "h2", "h3", "h4", "h5", "h6",
                    ".article-content", "#content", "#main-content"
            };

            for (String selector : selectors) {
                for (Element element : doc.select(selector)) {
                    String text = element.text().trim();
                    if (!text.isEmpty() && text.length() > 10) { // 过滤太短的内容
                        content.append(text).append("\n\n");
                    }
                }
            }

            String result = content.toString().trim();
            if (result.isEmpty()) {
                return "未能提取到有效内容";
            }

            return String.format("标题：%s\n\n正文：\n%s",
                    pageTitle,
                    result.replaceAll("\n{3,}", "\n\n")
            );

        } catch (Exception e) {
            log.error("抓取网页内容失败: {}", url, e);
            return "获取内容失败: " + e.getMessage();
        }
    }
}

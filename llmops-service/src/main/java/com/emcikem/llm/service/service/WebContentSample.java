package com.emcikem.llm.service.service;

import jakarta.annotation.Resource;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author zhuleiye02
 * @date 2025/1/26
 */
public class WebContentSample {
    public RestTemplate restTemplate(ClientHttpRequestFactory factory) {
        return new RestTemplate(factory);
    }

    public ClientHttpRequestFactory simpleClientHttpRequestFactory() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setReadTimeout(5000);
        factory.setConnectTimeout(15000);
        // 设置代理
        //factory.setProxy(null);
        return factory;
    }
    public String extractWebContent(String url) {
        RestTemplate restTemplate = restTemplate(simpleClientHttpRequestFactory());
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

        return formatOutput(pageTitle, content.toString());
    }

    private String formatOutput(String title, String content) {
        return String.format("%s\n\n%s",
                title,
                content.replaceAll("\n{3,}", "\n\n").trim()
        );
    }

    String fetchWebContent(String url) {
        try {
            // 设置请求头和超时
            org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
            headers.set("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36");
            RestTemplate restTemplate = restTemplate(simpleClientHttpRequestFactory());

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
            return "获取内容失败: " + e.getMessage();
        }
    }

    public static void main(String[] args) {
        WebContentSample sample = new WebContentSample();
        String url = "https://news.qq.com/rain/a/20220110A06U1G00";
        String content = sample.fetchWebContent(url);
        System.out.println(content);
    }
}

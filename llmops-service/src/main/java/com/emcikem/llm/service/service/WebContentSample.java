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

    public static void main(String[] args) {
        WebContentSample sample = new WebContentSample();
        String url = "https://www.cnblogs.com/zhangyinhua/p/8037599.html";
        String content = sample.extractWebContent(url);
        System.out.println(content);
    }
}

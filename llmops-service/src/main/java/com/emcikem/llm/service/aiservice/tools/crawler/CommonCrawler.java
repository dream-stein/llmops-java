package com.emcikem.llm.service.aiservice.tools.crawler;

import com.google.common.collect.Lists;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.net.URLEncoder;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Create with Emcikem on {DATE}
 *
 * @author Emcikem
 * @version 1.0.0
 */
public class CommonCrawler {

    public static String USER_DIR = System.getProperty("user.dir");

    public static String crawContent(String url, boolean isPersist) {
        String rootHtml = "";
        try {
            // 或取文档
            Document doc = CrawlerUtil.getDocument(url);
            // 数据清洗
            rootHtml = Jsoup.clean(doc.html(), CrawlerUtil.SAFELIST);

            // 持久化到本地
            if (isPersist) {
                Path filePath = Paths.get(Paths.get(USER_DIR, "data").toString(), URLEncoder.encode(url, "utf-8") + ".html");
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath.toFile()))) {
                    writer.write(rootHtml);
                }
            }

        } catch (Exception ex) {
            return null;
        }
        return rootHtml;
    }

    public static List<String> crawlTreeContent(String url, boolean isPersist) {
        List<String> htmls = Lists.newArrayList();
        if (!url.startsWith("https://")) {
            return htmls;
        }
        try {
            Document doc = CrawlerUtil.getDocument(url);
            String rootHtml = doc.html();
            htmls.add(Jsoup.clean(rootHtml, CrawlerUtil.SAFELIST));
            if (isPersist) {
                Path filePath = Paths.get(Paths.get(USER_DIR, "data").toString(), URLEncoder.encode(url, "utf-8") + ".html");
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath.toFile()))) {
                    writer.write(rootHtml);
                }
            }
            crawlTreeUrls(doc, 2).forEach(item -> {
                htmls.add(crawContent(item, isPersist));
            });
        } catch (Exception ex) {
            return htmls;
        }
        return htmls;
    }

    public static List<String> crawlTreeUrls(String url, int limit) {
        List<String> list = Lists.newArrayList();
        if (!url.startsWith("https://")) {
            return list;
        }
        try {
            Document doc = CrawlerUtil.getDocument(url);
            list.add(url);
            list = crawlTreeUrls(doc, limit).collect(Collectors.toList());
        } catch (Exception ex) {
            return list;
        }
        return list;
    }

    private static Stream<String> crawlTreeUrls(Document doc, int limit) {
        return doc.select("a[href]").stream()
                .map(link -> link.attr("href"))
                .filter(item -> item.startsWith("https://") && CrawlerUtil.IGNORE_URLS.stream().noneMatch(item::contains))
                .distinct()
                .limit(limit);
    }
}

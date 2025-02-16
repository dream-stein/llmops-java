package com.emcikem.llm.service.aiservice.tools.crawler;

import com.emcikem.llm.service.constant.Constant;
import com.emcikem.llm.service.util.CrawlerUtil;
import org.jetbrains.annotations.NotNull;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CommonCrawler {
    public static String crawlContent(String url, boolean isPersist) {
        String rootHtml = "";
        try {
            Document doc = CrawlerUtil.getDocument(url);
            rootHtml = Jsoup.clean(doc.html(), CrawlerUtil.SAFELIST);

            if (isPersist) {
                Path filePath = Paths.get(Constant.FILE_PATH.toString(), URLEncoder.encode(url, "utf-8") + ".html");
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath.toFile()))) {
                    writer.write(rootHtml);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
//        System.out.println("CommonCrawler: " + rootHtml);
        return rootHtml;
    }

    public static List<String> crawlTreeContent(String url, boolean isPersist) {
        List<String> htmls = new ArrayList<>();
        if (!url.startsWith("https://")) return htmls;
        try {
            Document doc = CrawlerUtil.getDocument(url);
            String rootHtml = doc.html();
            htmls.add(Jsoup.clean(rootHtml, CrawlerUtil.SAFELIST));
            if (isPersist) {
                Path filePath = Paths.get(Constant.FILE_PATH.toString(), URLEncoder.encode(url, "utf-8") + ".html");
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath.toFile()))) {
                    writer.write(rootHtml);
                }
            }
            crawlTreeUrls(doc, 2).forEach(item -> {
//                System.out.println(item);
                htmls.add(crawlContent(item, isPersist));
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        System.out.println(htmls);
        return htmls;
    }

    @NotNull
    public static List<String> crawlTreeUrls(String url, int limit) {
        List<String> list = new ArrayList<>();
        if (!url.startsWith("https://")) return list;
        try {
            Document doc = CrawlerUtil.getDocument(url);
            list.add(url);
            list = crawlTreeUrls(doc, limit).collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @NotNull
    private static Stream<String> crawlTreeUrls(Document doc, int limit) {
        return doc.select("a[href]").stream()
                .map(link -> link.attr("href"))
                .filter(item -> item.startsWith("https://") && CrawlerUtil.IGNORE_URLS.stream().noneMatch(item::contains))
                .distinct()
                .limit(limit);
    }
}

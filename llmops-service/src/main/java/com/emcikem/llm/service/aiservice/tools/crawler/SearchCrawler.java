package com.emcikem.llm.service.aiservice.tools.crawler;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.jsoup.nodes.Document;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Create with Emcikem on {DATE}
 *
 * @author Emcikem
 * @version 1.0.0
 */
public class SearchCrawler {

    public static final Map<String, String> searchEngines = new HashMap<>() {{
        put("baidu", "https://www.baidu.com/s?wd=");
        put("sogou", "https://www.sogou.com/web?query=");
        put("360", "https://www.so.com/s?q=");
        put("bing", "https://cn.bing.com/search?q=");
        put("quark", "https://quark.sm.cn/s?safe=1&q=");
    }};

    public static final List<String> failureMsg = Lists.newArrayList(
            "百度安全验证",
            "验证码",
            "操作过于频繁",
            "操作太频繁"
    );

    public static Map<String, Long> failureCache = new ConcurrentHashMap<>();

    public static String crawlFromEngine(String engine, String keyword) {
        String content = "";
        Map<String, String> engines = getValidEngines(failureCache);
        String[] keys = engines.keySet().toArray(new String[0]);
        if (keys.length == 0) {
            return content;
        }
        String webUrl = engines.get(engine);
        if (webUrl == null) {
            Random random = new Random();
            engine = keys[random.nextInt(keys.length)];
            webUrl = engines.get(engine);
        }
        content = CommonCrawler.crawContent(webUrl + keyword, false);
        if (failureMsg.stream().anyMatch(content::contains)) {
            failureCache.put(engine, System.currentTimeMillis());
            content = "SEARCH_FAILED";
        }
        return content;
    }

    private static Map<String, String> getValidEngines(Map<String, Long> filter) {
        long current = System.currentTimeMillis();
        return SearchCrawler.searchEngines.entrySet()
                .stream()
                .filter(entry -> current - filter.getOrDefault(entry.getKey(), current) < 60)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a));
    }
}

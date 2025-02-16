package com.emcikem.llm.service.aiservice.tools.crawler;

import com.emcikem.llm.service.constant.Constant;
import com.emcikem.llm.service.util.CommonUtil;
import com.emcikem.llm.service.util.CrawlerUtil;
import com.emcikem.llm.service.util.FileUtil;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import static com.emcikem.llm.service.constant.Constant.SEARCH_FAILED;

public class SearchCrawler {

    public static final Map<String, String> searchEngines = new HashMap<String, String>() {{
//        put("google", "https://www.google.com/search?q=");
        put("baidu", "https://www.baidu.com/s?wd=");
        put("sogou", "https://www.sogou.com/web?query=");
        put("360", "https://www.so.com/s?q=");
        put("bing", "https://cn.bing.com/search?q=");
        put("quark", "https://quark.sm.cn/s?safe=1&q=");
    }};

    public static final List<String> failureMsg = Arrays.asList(
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
            engine = keys[CommonUtil.randomIndex(keys.length)];
            webUrl = engines.get(engine);
        }
        content = CommonCrawler.crawlContent(webUrl + keyword, false);
//        System.out.println("crawlContent:\n" + content);
        if (failureMsg.stream().anyMatch(content::contains)) {
            failureCache.put(engine, System.currentTimeMillis());
            content = SEARCH_FAILED;
        }
        return content;
    }

    private static Map<String, String> getValidEngines(Map<String, Long> filter) {
        long current = System.currentTimeMillis();
        return SearchCrawler.searchEngines.entrySet()
                .stream()
                .filter(entry -> current - filter.getOrDefault(entry.getKey(), current) < 60 * 1000)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public static void main(String[] args) {
        FileUtil.mkDir(Constant.FILE_PATH);
        IpPoolCrawler ipPoolCrawler = new IpPoolCrawler();
        ipPoolCrawler.refresh();
        CrawlerUtil.IP_PORT_THREAD_LOCAL.set(ipPoolCrawler.load());
        try {
            System.out.println(crawlFromEngine("sogou", "今日双子座运势"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

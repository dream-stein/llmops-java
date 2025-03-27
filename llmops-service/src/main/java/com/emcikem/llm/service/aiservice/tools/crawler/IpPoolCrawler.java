package com.emcikem.llm.service.aiservice.tools.crawler;

import cn.hutool.core.collection.CollectionUtil;
import com.emcikem.llm.service.util.CrawlerUtil;
import com.emcikem.llm.service.util.FileUtil;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static com.emcikem.llm.service.constant.LLMOpsConstant.FILE_PATH;

@Slf4j
public class IpPoolCrawler {
    private static final Path ipPoolPath = Paths.get(FILE_PATH.toString(), "ip_pool.json");
    private static final int timeout = 1000;
    private static final List<String> urls = ConfigUtil.getConfigArr("ipPool.urls");
    private static final Gson gson = new Gson();

    private boolean checkHealth(IpPort ipPort) {
        try {
            Jsoup.connect("https://www.baidu.com")
                    .userAgent(CrawlerUtil.getUserAgent())
                    .proxy(ipPort.toProxy())
                    .timeout(timeout)
                    .get();
            return true;
        } catch (Exception e) {
//            e.printStackTrace();
            return false;
        }
    }

    public List<IpPort> recheck(List<IpPort> ipPorts) {
        List<IpPort> result = ipPorts.stream()
                .distinct()
                .filter(this::checkHealth)
                .collect(Collectors.toList());
        FileUtil.writeJson(ipPoolPath, gson.toJson(result));
        return result;
    }

    public List<IpPort> refresh() {
        List<IpPort> ipPorts = new ArrayList<>();
        ipPorts.addAll(getIpPool0());
        ipPorts.addAll(getIpPool1());
        ipPorts.addAll(getIpPool2());
        ipPorts.addAll(getIpPool3());
        List<IpPort> cache = CrawlerUtil.IP_PORT_THREAD_LOCAL.get();
        if (cache == null || cache.isEmpty()) {
            cache = load();
        }
        ipPorts.addAll(cache);
        log.info("[IpPoolCrawler] refresh, size: " + ipPorts.size());
        return recheck(ipPorts);
    }

    public List<IpPort> load() {
        try {
            String json = FileUtil.readJson(ipPoolPath);
            return gson.fromJson(json, new TypeToken<List<IpPort>>() {}.getType());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    private List<IpPort> getIpPool0() {
        if (CollectionUtil.isNotEmpty(urls)) {
            try {
                String url = urls.get(0);
                Document doc = CrawlerUtil.getDocument(url);
                String html = doc.select("body").html();
                String substring = "{" + html.substring(html.indexOf("\"TOTAL\":"));

                JsonObject jsonObject = gson.fromJson(substring, JsonObject.class);
                JsonArray lista = jsonObject.getAsJsonArray("LISTA");

                return gson.fromJson(lista, new TypeToken<List<IpPort>>() {}.getType());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return new ArrayList<>();
    }

    private List<IpPort> getIpPool1() {
        if (CollectionUtil.isNotEmpty(urls)) {
            try {
                String url = urls.get(1);
                Document doc = CrawlerUtil.getDocument(url);
                String html = doc.select("body").html();
                return getIpPortsByPattern(html);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return new ArrayList<>();
    }

    private List<IpPort> getIpPool2() {
        if (CollectionUtil.isNotEmpty(urls)) {
            try {
                String url = urls.get(2);
                Document doc = CrawlerUtil.getDocument(url);
                String html = doc.select("body > script").html();
                return getIpPortsByPattern(html);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return new ArrayList<>();
    }

    private List<IpPort> getIpPool3() {
        if (CollectionUtil.isNotEmpty(urls)) {
            try {
                String url = urls.get(3);
                Document doc = CrawlerUtil.getDocument(url);
                Element lastPageLink = doc.select("a:containsOwn(尾页)").first();
                if (lastPageLink != null) {
                    String lastHref = lastPageLink.attr("href");
                    String seperator = "page=";
                    if (lastHref.contains(seperator)) {
                        int totalPage = Integer.parseInt(lastHref.split(seperator)[1]);
                        List<IpPort> ipPorts = new ArrayList<>();
                        for (int page = 1; page <= totalPage; page++) {
                            if (page > 2) {
                                doc = CrawlerUtil.getDocument(url + lastHref.split(seperator)[0] + seperator + page);
                            }
                            ipPorts.addAll(getIpPortsByTable(doc));
                        }
                        return ipPorts;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return new ArrayList<>();
    }

    private List<IpPort> getIpPool4() {
        if (CollectionUtil.isNotEmpty(urls)) {
            try {
                String url = urls.get(4) + "inha";
                Document doc = CrawlerUtil.getDocument(url);
                Elements links = doc.select("a");
                System.out.println(doc.html());
                System.out.println(links.html());
                System.out.println(getIpPortsByTable(doc));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return new ArrayList<>();
    }

    @NotNull
    private static List<IpPort> getIpPortsByPattern(String html) {
        String regex = "\\d{1,3}(\\.\\d{1,3}){3}:\\d{1,5}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(html);

        List<IpPort> ipList = new ArrayList<>();
        while (matcher.find()) {
            String match = matcher.group();
            String[] raw = match.split(":");
            ipList.add(new IpPort(raw[0], Integer.parseInt(raw[1])));
        }
        return ipList;
    }

    private static List<IpPort> getIpPortsByTable(Document doc) {
        List<IpPort> ipPorts = new ArrayList<>();
        Element tbody = doc.select("tbody").first();
        if (tbody != null) {
            Elements rows = tbody.select("tr");
            for (Element row : rows) {
                Element firstTd = row.select("td").first();
                Element secondTd = row.select("td").get(1);
                if (firstTd != null && secondTd != null) {
                    ipPorts.add(new IpPort(firstTd.text(), Integer.parseInt(secondTd.text())));
                }
            }
        }
        return ipPorts;
    }
}

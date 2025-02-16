package com.emcikem.llm.service.aiservice.tools.crawler;

import cn.hutool.http.HttpUtil;
import com.emcikem.llm.service.util.CrawlerUtil;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
public class WeiBoCrawler {
    private static final Gson gson = new Gson();

    public static String crawlWeiboTops() {
        String html = "";
        try {
            String tid = crawlWeiboTid();
            String cookie = crawlWeiBoCookie(tid);

            OkHttpClient httpClient = new OkHttpClient();
            String userAgent = CrawlerUtil.getUserAgent();
            Request request = new Request.Builder()
                    .url("https://s.weibo.com/top/summary?cate=realtimehot")
                    .addHeader("Cookie", cookie)
                    .addHeader("User-Agent", userAgent)
                    .build();
            try (Response response = httpClient.newCall(request).execute()) {
                ResponseBody responseBody = response.body();

                if (response.isSuccessful() && responseBody != null) {
                    html = responseBody.string();
                    Document document = Jsoup.parse(html);
                    Element item = document.getElementsByTag("tbody").first();
                    if (item != null) {
                        List<String> news = item.getElementsByTag("tr").stream()
                                .map(ele -> String.format("%s (https://s.weibo.com%s)", ele.text(),
                                        ele.select("a[href]").attr("href")))
                                .filter(it -> !it.contains("javascript:void(0);"))
                                .skip(1)
                                .collect(Collectors.toList());
                        return String.join("\n", news);
                    }
                } else {
                    log.warn("Request failed");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return html;
    }

    @NotNull
    private static String crawlWeiBoCookie(String tid) {
        String subUrl = "https://passport.weibo.com/visitor/visitor";
        Map<String, Object> params2 = new HashMap<>();
        params2.put("a", "incarnate");
        params2.put("t", tid);
        params2.put("w", "3");
        params2.put("c", "100");
        params2.put("cb", "cross_domain");
        params2.put("from", "weibo");
        String str2 = HttpUtil.get(subUrl, params2, 3000);
        String resultStr = str2.substring(str2.indexOf("(") + 1, str2.indexOf(")"));
        String sub = "";
        String subp = "";
        if (!resultStr.isEmpty()) {
            JsonObject result = gson.fromJson(resultStr, JsonObject.class);
            if (result.get("retcode").getAsInt() == 20000000) {
                sub = result.getAsJsonObject("data").get("sub").getAsString();
                subp = result.getAsJsonObject("data").get("subp").getAsString();
            }
        }
        return "SUB=" + sub + ";SUBP=" + subp + ";";
    }

    private static String crawlWeiboTid() {
        String tidUrl = "https://passport.weibo.com/visitor/genvisitor";
        Map<String, Object> params = new HashMap<>();
        params.put("cb", "gen_callback");
        String str = HttpUtil.get(tidUrl, params, 3000);
        String quStr = str.substring(str.indexOf("(") + 1, str.indexOf(")"));
        String tid = "";
        if (!quStr.isEmpty()) {
            JsonObject result = gson.fromJson(quStr, JsonObject.class);
            if (result.get("retcode").getAsInt() == 20000000) {
                tid = result.getAsJsonObject("data").get("tid").getAsString();
            }
        }
        return tid;
    }
}
package com.emcikem.llm.service.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

import static com.emcikem.llm.service.constant.Constant.SEARCH_FAILED;

public class CacheUtil {
    private static final Map<String, String> cache = new ConcurrentHashMap<>();
    private static final long expires = 10 * 60 * 1000;
    private static final Gson gson = new Gson();

    public static <T> T cacheFunc(String key, Function<Void, T> function) {
        long current = System.currentTimeMillis();
        if (cache.containsKey(key)) {
            String obj = cache.get(key);
            int timeIdx = obj.indexOf("&");
            long last = Long.parseLong(obj.substring(0, timeIdx));
            if (current - last < expires) {
                return gson.fromJson(obj.substring(timeIdx + 1), new TypeToken<T>() {}.getType());
            }
        }
        T result = function.apply(null);
        if (result != null && !SEARCH_FAILED.equals(String.valueOf(result))) {
            cache.put(key, current + "&" + gson.toJson(result));
        }
        return result;
    }

    public static void reset() {
        cache.clear();
    }
}

package com.emcikem.llm.service.aiservice.tools.crawler;

import com.emcikem.llm.service.constant.Constant;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.jetbrains.annotations.NotNull;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;

public class ConfigUtil {
    private static final String yamlFilePath = "custom-config.yml";
    private static final Gson gson = new Gson();
    private static JsonObject configJson = new JsonObject();

    static {
        loadDefaultConfig();
    }

    private static void loadDefaultConfig() {
        Yaml yaml = new Yaml();
        try (InputStream in = ConfigUtil.class.getClassLoader().getResourceAsStream(yamlFilePath)) {
            Map<String, Object> config = yaml.load(in);
            String json = gson.toJson(config);
            configJson = gson.fromJson(json, JsonObject.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void updateConfigJson(JsonObject oldJson, JsonObject newJson) {
        for (String key : newJson.keySet()) {
            JsonElement newVal = newJson.get(key);
            if (oldJson.has(key) && oldJson.get(key).isJsonObject() && newVal.isJsonObject()) {
                updateConfigJson(oldJson.getAsJsonObject(key), newVal.getAsJsonObject());
            } else {
                oldJson.add(key, newVal);
            }
        }
    }

    public static void loadCustomConfig(String pluginFolder) {
        Yaml yaml = new Yaml();
        String configFilePath = String.format("plugins/%s/%s", pluginFolder, yamlFilePath);
        File configFile = new File(Constant.USER_DIR, configFilePath);
        try (FileReader reader = new FileReader(configFile)) {
            Map<String, Object> config = yaml.load(reader);
            String json = gson.toJson(config);
            JsonObject customConfigJson = gson.fromJson(json, JsonObject.class);
            updateConfigJson(configJson, customConfigJson);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static <T> List<T> getConfigArr(@NotNull String key, Class<T> clazz) {
        try {
            String[] path = key.split("\\.");
            int index = 0;
            JsonObject curJson = configJson;
            while (index < path.length - 1) {
                curJson = curJson.getAsJsonObject(path[index]);
                if (curJson == null) {
                    return null;
                }
                index++;
            }
            String leaf = path[path.length - 1];
            JsonElement leafElement = curJson.get(leaf);
            if (leafElement == null) {
                return null;
            }
            if (leafElement.isJsonArray()) {
                JsonArray jsonArray = leafElement.getAsJsonArray();
                return jsonArray
                        .asList().stream()
                        .map(element -> gson.fromJson(element, clazz))
                        .collect(Collectors.toList());
            } else {
                return Collections.singletonList(gson.fromJson(leafElement, clazz));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<String> getConfigArr(@NotNull String key) {
        return Optional.ofNullable(getConfigArr(key, Object.class)).orElse(new ArrayList<>()).stream()
                .map(String::valueOf)
                .collect(Collectors.toList());
    }

    public static <T> T getConfig(@NotNull String key, Class<T> clazz, T defaultValue) {
        List<T> list = getConfigArr(key, clazz);
        if (list == null || list.isEmpty()) {
            return defaultValue;
        }
        return list.get(0);
    }

    public static <T> T getConfig(@NotNull String key, Class<T> clazz) {
        return getConfig(key, clazz, null);
    }

    public static String getConfig(@NotNull String key) {
        return getConfig(key, String.class);
    }
}

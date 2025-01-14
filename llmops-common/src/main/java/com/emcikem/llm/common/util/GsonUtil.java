package com.emcikem.llm.common.util;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Create with Emcikem on 2024/11/21
 *
 * @author Emcikem
 * @version 1.0.0
 */
public class GsonUtil {

    private final static Gson GSON = new GsonBuilder().registerTypeAdapter(Date.class, new DateTypeAdapter()).create();

    public static String toJSONString(Object object) {
        if (object == null) {
            return "";
        }
        return GSON.toJson(object);
    }

    public static <T> T parseObject(String json, Class<T> clz) {
        if (StringUtils.isBlank(json)) {
            return null;
        }
        return GSON.fromJson(json, clz);
    }

    public static <T> List<T> parseList(String json, Class<T> clazz) {
        if (StringUtils.isBlank(json)) {
            return Collections.emptyList();
        }
        Type type = new ParameterizedType() {
            @Override
            public Type[] getActualTypeArguments() {
                return new Type[]{clazz};
            }

            @Override
            public Type getRawType() {
                return List.class;
            }

            @Override
            public Type getOwnerType() {
                return null;
            }
        };
        return GSON.fromJson(json, type);
    }

    public static <T> Map<String, T> gsonToMaps(String gsonString) {
        Map<String, T> map = null;
        if (GSON != null) {
            map = GSON.fromJson(gsonString, new TypeToken<Map<String, T>>() {
            }.getType());
        }
        return map;
    }

    public static class DateTypeAdapter implements JsonSerializer<Date>, JsonDeserializer<Date> {
        @Override
        public Date deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {
            try {
                return NumberUtils.isParsable(json.getAsJsonPrimitive().getAsString()) ? new Date(json.getAsJsonPrimitive().getAsLong()) : DateUtils.parseDate(json.getAsJsonPrimitive().getAsString(), new String[]{"yyyy-MM-dd HH:mm:ss"});
            } catch (ParseException e) {
                throw new IllegalArgumentException("DateTypeAdapter.deserialize fail!", e);
            }
        }

        @Override
        public JsonElement serialize(Date date, Type type, JsonSerializationContext jsonSerializationContext) {
            return new JsonPrimitive(date.getTime());
        }
    }
}

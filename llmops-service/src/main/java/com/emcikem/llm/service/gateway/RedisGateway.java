package com.emcikem.llm.service.gateway;

import com.google.common.collect.Maps;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Create with Emcikem on 2024/11/21
 *
 * @author Emcikem
 * @version 1.0.0
 */
@Service
@Slf4j
public class RedisGateway {

    private static final String COMPARE_AND_DELETE =
            "local cV = redis.call('get', KEYS[1]); "
                    + "if cV == ARGV[1] "
                    + "or (tonumber(ARGV[1]) == 0 and cV == false) then "
                    + " redis.call('del', KEYS[1]); "
                    + "return 1 "
                    + " else "
                    + " return 0 "
                    + " end";

    public static final RedisScript<Boolean> COMPARE_AND_DELETE_SCRIPT = new DefaultRedisScript<>(COMPARE_AND_DELETE, Boolean.class);

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * string-get
     */
    public <T> T get(String key) {
        try {
            return (T) redisTemplate.opsForValue().get(key);
        } catch (Exception e) {
            log.error("get value failed, key:{}", key, e);
            return null;

        }
    }

    /**
     * string-set
     */
    public void set(String key, Object value, Long expire) {
        try {
            if (expire == null) {
                redisTemplate.opsForValue().set(key, value);
            } else {
                redisTemplate.opsForValue().set(key, value, expire, TimeUnit.SECONDS);
            }
        } catch (Exception e) {
            log.error("set value:{} failed, key:{}", value, key, e);
        }
    }

    /**
     * string-mset
     * @param msetMap
     */
    public void mhset(Map<String, Object> msetMap) {
        try {
            redisTemplate.opsForValue().multiSet(msetMap);
        } catch (Exception e) {
            log.error("set failed, msetMap:{}", msetMap, e);
        }
    }

    /**
     * string-incr
     */
    public Long incr(String key) {
        try {
            return redisTemplate.opsForValue().increment(key);
        } catch (Exception e) {
            log.error("incr key:{} failed", key, e);
        }
        return 0L;
    }

    /**
     * hash-set
     */
    public void hset(String hkey, String key, String value) {
        try {
            redisTemplate.opsForHash().put(key, hkey, value);
        } catch (Exception e) {
            log.error("set hash key failed, hkey:{}, key:{}", hkey, key, e);
        }
    }

    public <T> T get(String hkey, String key, Class<T> clz) {
        try {
            Object value = redisTemplate.opsForHash().get(key, hkey);
            return clz.cast(value);
        } catch (Exception e) {
            log.error("get hash key failed, hkey:{}, key:{}", hkey, key, e);
            return null;
        }
    }

    public Boolean delete(String key) {
        try {
            return redisTemplate.delete(key);
        } catch (Exception e) {
            log.error("delete key falied, key:{}", key, e);
            return Boolean.FALSE;
        }
    }

    /**
     * 获取hash下key里的
     * 所有hashKey和它的值
     * @param key
     * @return
     */
    public Map<String, Object> hgetAll(String key) {
        try {
            Map<Object, Object> entries = redisTemplate.opsForHash().entries(key);
            Map<String, Object> stringObjectMap = Maps.newHashMap();
            entries.forEach((k, v) -> stringObjectMap.put((String) k, v));
            return stringObjectMap;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * compare value of key in redis with value
     * and then delete
     * @param key
     * @param value
     * @return
     */
    public boolean compareAndDelete(String key, Object value) {
        try {
            return Boolean.TRUE.equals(redisTemplate.execute(COMPARE_AND_DELETE_SCRIPT, Collections.singletonList(key), value));
        } catch (Exception e) {
            log.error("compareAndDelete failed, key:{}, value:{}", key, value, e);
            return Boolean.FALSE;
        }
    }
}

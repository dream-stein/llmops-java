package com.emcikem.llm.service.gateway;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.UUID;

/**
 * Create with Emcikem on 2024/11/21
 *
 * @author Emcikem
 * @version 1.0.0
 */
@Slf4j
@        Component
public class RedisLockGateway {

    private static final Logger LOGGER = LoggerFactory.getLogger(RedisLockGateway.class);

    private final ThreadLocal<String> LOCAL = new ThreadLocal<>();

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Resource
    private RedisGateway redisGateway;

    /**
     *
     * @param key
     * @param timeoutMills 加锁，尝试 多少毫秒。null表示不尝试
     * @param keyExpireSecond key过期的时间
     * @return
     */
    public boolean lock(String key, Long timeoutMills, int keyExpireSecond) {
        try {
            LOCAL.set(UUID.randomUUID().toString());
            long start = System.currentTimeMillis();
            boolean result;
            ValueOperations<String, Object> opsForValue = redisTemplate.opsForValue();
            while (!(result = Boolean.TRUE.equals(opsForValue.setIfAbsent(key, LOCAL.get(), Duration.ofSeconds(keyExpireSecond))))
                    && timeoutMills != null && (System.currentTimeMillis() - start) < timeoutMills) {
                Thread.sleep(10);
            }
            return result;
        } catch (Exception e) {
            log.error("tryLock fail,key: {}", key, e);
            return true;
        }
    }

    /**
     * 释放锁
     * @param key
     * @return
     */
    public boolean unLock(String key) {
        try {
            if (StringUtils.isBlank(LOCAL.get())) {
                return false;
            }
            return redisGateway.compareAndDelete(key, LOCAL.get());
        } catch (Exception e) {
            log.error("unLock fail,key:{}", key, e);
            return false;
        } finally {
            LOCAL.remove();
        }
    }
}

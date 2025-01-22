package com.emcikem.llm.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Create with Emcikem on 2025/1/22
 *
 * @author Emcikem
 * @version 1.0.0
 */
@Configuration
public class ThreadPoolConfig {

    @Bean("historyPool")
    public ExecutorService historyPool() {
        return Executors.newFixedThreadPool(3);
    }
}

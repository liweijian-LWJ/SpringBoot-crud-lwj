package com.lwj.crud.config;

import com.lwj.crud.util.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
@Order(1)
public class DelRedisCache implements CommandLineRunner {
    protected final Logger logger = LoggerFactory.getLogger(DelRedisCache.class);
    @Value("${redis.cache.key}")
    private String key;
    @Autowired
    RedisUtil redisUtil;

    @Override
    public void run(String... args) throws Exception {
        redisUtil.delKey("*" + key);
        logger.info("--初始化Redis--");
    }
}

package com.frankzhou.redis.cache;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 封装对于缓存穿透、缓存击穿的通用解决方案  保证缓存一致性 缓存空值(缓存击穿)  互斥锁/设置逻辑过期时间(缓存穿透)
 * @date 2023-02-18
 */
@Slf4j
@Component
@SuppressWarnings(value = { "unchecked", "rawtypes" })
public class RedisCache {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    private static final ExecutorService CACHE_REBUILD = Executors.newFixedThreadPool(100);


}

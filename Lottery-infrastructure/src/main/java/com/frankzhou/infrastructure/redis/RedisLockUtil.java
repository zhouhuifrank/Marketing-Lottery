package com.frankzhou.infrastructure.redis;

import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description Redis分布式锁工具类
 * @date 2023-02-02
 */
public class RedisLockUtil implements IRedisLock {

    private static final String DISTRIBUTED_LOCK = "distributed:lock:";

    private String name;

    private StringRedisTemplate stringRedisTemplate;

    RedisLockUtil(String name,StringRedisTemplate stringRedisTemplate) {
        this.name = name;
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @Override
    public boolean tryLock(Long timeSec) {
        return false;
    }

    @Override
    public void unlock() {

    }
}

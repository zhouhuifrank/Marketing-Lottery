package com.frankzhou.infrastructure.redis;

import cn.hutool.core.util.BooleanUtil;
import cn.hutool.core.util.RandomUtil;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description Redis分布式锁工具类
 * @date 2023-02-02
 */
@Component
public class RedisLockUtil implements IRedisLock {

    private String name = "award:stock";

    private StringRedisTemplate stringRedisTemplate;

    private static final String DISTRIBUTED_LOCK = "distributed:lock:";

    private static final String ID_PREFIX = UUID.randomUUID().toString() + "-";

    private static final DefaultRedisScript<Long> UNLOCK_SCRIPT;
    static {
        UNLOCK_SCRIPT = new DefaultRedisScript<>();
        UNLOCK_SCRIPT.setLocation(new ClassPathResource("unlock.lua"));
        UNLOCK_SCRIPT.setResultType(Long.class);
    }

    RedisLockUtil(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @Override
    public boolean tryLock(Long timeSec) {
        String lockKey = DISTRIBUTED_LOCK + name;
        String threadId = ID_PREFIX + Thread.currentThread().getId();
        Boolean isLock = stringRedisTemplate.opsForValue().setIfAbsent(lockKey, threadId, timeSec, TimeUnit.SECONDS);
        return BooleanUtil.isTrue(isLock);
    }

    @Override
    public void unlock() {
        String threadId = ID_PREFIX + Thread.currentThread().getId();
        stringRedisTemplate.execute(
                UNLOCK_SCRIPT,
                Collections.singletonList(DISTRIBUTED_LOCK+name),
                threadId);
    }
}

package com.frankzhou.domain.ids.generator;

import com.frankzhou.domain.ids.IIdGenerator;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description
 * @date 2023-02-02
 */
@Component(value = "RedisId")
public class RedisId implements IIdGenerator {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    private static final int BITS_COUNT = 32;

    private static final long BEGIN_TIMESTAMP = 1675991375L;

    private static final String KEY_PREFIX = "order";

    @Override
    public Long nextId() {
        // 生成32位时间戳
        LocalDateTime now = LocalDateTime.now();
        long nowSecond = now.toEpochSecond(ZoneOffset.UTC);
        long timestamp = nowSecond - BEGIN_TIMESTAMP;

        String date = now.format(DateTimeFormatter.ofPattern("yyyy:MM:dd"));
        long increment = stringRedisTemplate.opsForValue().increment("incr:" + KEY_PREFIX + ":" + date);

        return timestamp << BITS_COUNT | increment;
    }

}

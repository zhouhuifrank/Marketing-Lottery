package com.frankzhou.lottery.redis;

import com.frankzhou.redis.cache.StringRedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description
 * @date 2023-02-09
 */
@SpringBootTest
public class StringTemplateTest {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private StringRedisUtil stringRedisUtil;

    @Test
    public void testStringCache() {
        String key = "test:string";
        stringRedisUtil.setStringObject(key,10);
        String stringObject = stringRedisUtil.getStringObject(key, String.class);
        System.out.println(stringObject);
    }
}

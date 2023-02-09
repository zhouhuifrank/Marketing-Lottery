package com.frankzhou.lottery.redis;

import com.frankzhou.infrastructure.redis.RedisLockUtil;
import com.frankzhou.infrastructure.redis.RedisUtil;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description
 * @date 2023-02-09
 */
@SpringBootTest
public class RedisTemplateTest {

    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private RedisUtil redisUtil;


}

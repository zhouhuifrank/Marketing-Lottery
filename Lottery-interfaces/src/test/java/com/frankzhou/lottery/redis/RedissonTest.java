package com.frankzhou.lottery.redis;

import com.frankzhou.redis.cache.RedisLockUtil;
import org.junit.jupiter.api.Test;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description
 * @date 2023-02-09
 */
@SpringBootTest
public class RedissonTest {

    @Resource
    private RedissonClient redissonClient;

    @Resource
    private RedisLockUtil redisLockUtil;

    @Test
    public void testLock() throws InterruptedException {
        RLock lock = redissonClient.getLock("any");
        boolean isLock = lock.tryLock(1,10,TimeUnit.SECONDS);
        if (isLock) {
            System.out.println("获取分布式锁成功");
            try {
                System.out.println("执行业务");
            } finally {
                System.out.println("释放锁");
                lock.unlock();
            }
        } else {
            System.out.println("获取分布式锁失败");
        }
    }

    @Test
    public void testPlainLock() {
        boolean flag = redisLockUtil.tryLock(10L);
        if (flag) {
            System.out.println("获取分布式锁成功");
            try {
                System.out.println("执行业务");
            } finally {
                System.out.println("释放锁");
                redisLockUtil.unlock();
            }
        } else {
            System.out.println("获取分布式锁失败");
        }
    }
}

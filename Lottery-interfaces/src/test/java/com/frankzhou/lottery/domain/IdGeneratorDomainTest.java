package com.frankzhou.lottery.domain;

import com.alibaba.nacos.shaded.org.checkerframework.checker.units.qual.C;
import com.frankzhou.common.constants.IdGeneratorType;
import com.frankzhou.domain.ids.IIdGenerator;
import com.frankzhou.domain.ids.generator.RedisId;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description
 * @date 2023-02-09
 */
@Slf4j
@SpringBootTest
public class IdGeneratorDomainTest {

    @Resource
    private Map<IdGeneratorType,IIdGenerator> idMap;

    @Resource
    private RedisId redisId;

    private static ExecutorService ID_GENERATOR = Executors.newFixedThreadPool(100);

    @Test
    public void testSnowFlake() throws InterruptedException {
        IIdGenerator snowFlake = idMap.get(IdGeneratorType.SNOW_FLAKE);
        CountDownLatch latch = new CountDownLatch(300);

        Runnable task = () -> {
            for (int i=0;i<100;i++) {
                System.out.println(snowFlake.nextId());
            }
            latch.countDown();
        };

        long startTime = System.currentTimeMillis();
        for (int i=0;i<300;i++) {
            ID_GENERATOR.submit(task);
        }
        latch.await();
        long endTime = System.currentTimeMillis();
        log.info("run time:{}ms",(endTime-startTime));
    }

    @Test
    public void testRedis() {
        long id = redisId.nextId();
        System.out.println(id);
    }

    @Test
    public void testRedisId() throws InterruptedException {
        IIdGenerator redisId = idMap.get(IdGeneratorType.REDIS_ID);
        CountDownLatch latch = new CountDownLatch(300);

        Runnable task = () -> {
            for (int i=0;i<100;i++) {
                long id = redisId.nextId();
                System.out.println(id);
            }
            latch.countDown();
        };

        long startTime = System.currentTimeMillis();
        for (int i=0;i<300;i++) {
            ID_GENERATOR.submit(task);
        }
        latch.await();
        long endTime = System.currentTimeMillis();
        log.info("run time:{}ms",(endTime-startTime));
    }

    @Test
    public void testRandomNumber() throws InterruptedException {
        IIdGenerator randomNumber = idMap.get(IdGeneratorType.RANDOM_NUMBER);
        CountDownLatch latch = new CountDownLatch(300);

        Runnable task = () -> {
            for (int i=0;i<100;i++) {
                System.out.println(randomNumber.nextId());
            }
            latch.countDown();
        };

        long startTime = System.currentTimeMillis();
        for (int i=0;i<300;i++) {
            ID_GENERATOR.submit(task);
        }
        latch.await();
        long endTime = System.currentTimeMillis();
        log.info("run time:{}ms",(endTime-startTime));
    }

    @Test
    public void testTimeCode() throws InterruptedException {
        IIdGenerator timeCode = idMap.get(IdGeneratorType.TIME_CODE);
        CountDownLatch latch = new CountDownLatch(300);

        Runnable task = () -> {
            for (int i=0;i<100;i++) {
                System.out.println(timeCode.nextId());
            }
            latch.countDown();
        };

        long startTime = System.currentTimeMillis();
        for (int i=0;i<300;i++) {
            ID_GENERATOR.submit(task);
        }
        latch.await();
        long endTime = System.currentTimeMillis();
        log.info("run time:{}ms",(endTime-startTime));
    }
}

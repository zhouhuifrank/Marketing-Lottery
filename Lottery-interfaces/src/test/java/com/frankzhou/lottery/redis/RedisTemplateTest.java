package com.frankzhou.lottery.redis;

import com.alibaba.fastjson.JSON;
import com.frankzhou.redis.cache.RedisUtil;
import com.frankzhou.redis.cache.SortedSetData;
import com.frankzhou.rpc.req.ActivityReq;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description redisUtil测试类 测试通过
 * @date 2023-02-09
 */
@SpringBootTest
public class RedisTemplateTest {

    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private RedisUtil redisUtil;

    @Test
    public void testCommonRedis() {
        redisUtil.setCacheString("test:1","frankzhou");
        redisUtil.setExpire("test:1",2L, TimeUnit.MINUTES);
        long expire = redisUtil.getExpire("test:1");
        System.out.println(expire);
        redisUtil.deleteObject("test:1");
    }

    @Test
    public void testStringRedis() {
        String key = "test:zhou";
        redisUtil.setCacheString(key,"zhouhui",2L,TimeUnit.MINUTES);
        Object cacheString = redisUtil.getCacheString(key);
        System.out.println(cacheString);
    }

    @Test
    public void testCacheObject() {
        String key = "test:activity";
        ActivityReq activityReq = new ActivityReq();
        activityReq.setActivityId(100001L);
        activityReq.setUId("zhouhui");
        redisUtil.setCacheString(key,activityReq);
        ActivityReq cacheString = (ActivityReq) redisUtil.getCacheString(key);
        System.out.println(JSON.toJSONString(cacheString));
    }

    @Test
    public void testHashRedis() {
        String key = "test:user";
        Map<String,Object> hash = new HashMap<>();
        hash.put("sex","男");
        hash.put("gender",2);
        hash.put("girlfrient","xintong");
        redisUtil.setCacheHash(key,hash);
        Map<Object, Object> cacheHash = redisUtil.getCacheHash(key);
        System.out.println(cacheHash);
    }

    @Test
    public void testHashFieldRedis() {
        String key = "test:hash";
        redisUtil.setCacheHashValue(key,"name","zhou");
        redisUtil.setCacheHashValue(key,"sex","男");
        redisUtil.setCacheHashValue(key,"age",2);
        System.out.println("取出一个字段");
        Object age = redisUtil.getCacheMapValue(key, "age");
        System.out.println(age);
        System.out.println("取出所有字段");
        List<Object> keyList = Arrays.asList("name","sex","age");
        List<Object> multiCacheMapValue = redisUtil.getMultiCacheMapValue(key, keyList);
        System.out.println(multiCacheMapValue);
    }

    @Test
    public void testListRedis() {
        String key = "test:list";
        List<String> stringList = Arrays.asList("name","zhou","hui","ai","xintong");
        redisUtil.setCacheList(key,stringList,2L,TimeUnit.MINUTES);
        List<Object> cacheList = redisUtil.getCacheList(key);
        System.out.println(cacheList);
    }

    @Test
    public void testSetRedis() {
        String key = "test:set";
        Set<String> stringSet = new HashSet<>();
        stringSet.add("zhou");
        stringSet.add("zhou");
        stringSet.add("hui");
        stringSet.add("xintong");
        redisUtil.setCacheSet(key,stringSet,2L,TimeUnit.MINUTES);
        Set<Object> cacheSet = redisUtil.getCacheSet(key);
        System.out.println(cacheSet);
    }

    @Test
    public void testZSetRedis() {
        String key = "test:sorted:set";
        Set<SortedSetData> sortedSet = new HashSet<>();
        sortedSet.add(new SortedSetData(1,"zhouhui"));
        sortedSet.add(new SortedSetData(5,"xintong"));
        sortedSet.add(new SortedSetData(3,"frankzhou"));
        redisUtil.setCacheZSet(key,sortedSet,2L,TimeUnit.MINUTES);
        Set<Object> cacheZSet = redisUtil.getCacheZSet(key);
        System.out.println(cacheZSet);
    }
}

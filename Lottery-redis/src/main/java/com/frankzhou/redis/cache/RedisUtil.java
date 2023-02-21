package com.frankzhou.redis.cache;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 封装RedisTemplate对于各种数据类型的操作
 * @date 2023-02-02
 */
@Slf4j
@Component
@SuppressWarnings(value = { "unchecked", "rawtypes" })
public class RedisUtil {
    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    // =================通用redis操作====================

    public boolean setExpire(final String key, final Long time, final TimeUnit unit) {
        try {
            if (time > 0) {
                return redisTemplate.expire(key, time, unit);
            }
            return false;
        } catch (Exception e) {
            log.warn("Redis服务异常");
        }
        return false;
    }

    public boolean setExpire(final String key, final Long time) {
        try {
            if (time > 0) {
                return redisTemplate.expire(key, time, TimeUnit.SECONDS);
            }
            return false;
        } catch (Exception e) {
            log.warn("Redis服务异常");
        }
        return false;
    }

    public long getExpire(final String key) {
        long expire = (long) redisTemplate.getExpire(key);
        return expire;
    }

    public boolean deleteObject(final String key) {
        try {
            Boolean flag = redisTemplate.delete(key);
            return flag.equals(Boolean.TRUE) ? true : false;
        } catch (Exception e) {
            log.warn("Redis服务异常");
        }
        return false;
    }

    public long deleteObject(final Collection<String> collection) {
        try {
            Long count = redisTemplate.delete(collection);
            return count == null ? 0 : count;
        } catch (Exception e) {
            log.warn("Redis服务异常");
        }
        return 0;
    }


    // =================String类型操作===================

    public <T> void setCacheString(final String key, final T value) {
        try {
            redisTemplate.opsForValue().set(key,value);
        } catch (Exception e) {
            log.warn("Redis服务异常");
        }
    }

    public <T> void setCacheString(final String key, final T value, final Long time, final TimeUnit unit) {
        try {
            redisTemplate.opsForValue().set(key,value,time,unit);
        } catch (Exception e) {
            log.warn("Redis服务异常");
        }
    }

    public Object getCacheString(final String key) {
        try {
            return redisTemplate.opsForValue().get(key);
        } catch (Exception e) {
            log.warn("Redis服务异常");
        }
        return null;
    }


    // =================Hash类型操作======================

    public <T> void setCacheHash(final String key, final Map<String,Object> objectMap) {
        try {
            redisTemplate.opsForHash().putAll(key,objectMap);
        } catch (Exception e) {
            log.warn("Redis服务异常");
        }
    }

    public <T> void setCacheHash(final String key, final Map<String,T> objectMap, final Long time, final TimeUnit unit) {
        try {
            redisTemplate.opsForHash().putAll(key,objectMap);
            redisTemplate.expire(key,time,unit);
        } catch (Exception e) {
            log.warn("Redis服务异常");
        }
    }

    public <T> void setCacheHashValue(final String key, final String hKey, final T value ) {
        try {
            redisTemplate.opsForHash().put(key,hKey,value);
        } catch (Exception e) {
            log.warn("Redis服务异常");
        }
    }

    public <T> T getCacheMapValue(final String key, final String hKey) {
        try {
            HashOperations<String, String, T> opsForHash = redisTemplate.opsForHash();
            return opsForHash.get(key, hKey);
        } catch (Exception e) {
            log.warn("Redis服务异常");
        }
        return null;
    }

    public List<Object> getMultiCacheMapValue(final String key, final Collection<Object> hKeys) {
        try {
            return redisTemplate.opsForHash().multiGet(key, hKeys);
        } catch (Exception e) {
            log.warn("Redis服务异常");
        }
        return null;
    }

    public <T> Map<Object, Object> getCacheHash(final String key) {
        try {
            return redisTemplate.opsForHash().entries(key);
        } catch (Exception e) {
            log.warn("Redis服务异常");
        }
        return null;
    }

    // =================List类型操作======================

    public <T> void setCacheList(final String key, final List<T> dataList) {
        try {
            redisTemplate.opsForList().rightPush(key,dataList);
        } catch (Exception e) {
            log.warn("Redis服务异常");
        }
    }

    public <T> void setCacheList(final String key, final List<T> dataList, final Long time, final TimeUnit unit) {
        try {
            redisTemplate.opsForList().rightPush(key,dataList);
            redisTemplate.expire(key,time,unit);
        } catch (Exception e) {
            log.warn("Redis服务异常");
        }
    }

    public List<Object> getCacheList(final String key) {
        try {
            List<Object> result = redisTemplate.opsForList().range(key, 0, -1);
            return result;
        } catch (Exception e) {
            log.warn("Redis服务异常");
        }
        return null;
    }


    // =================Set类型操作=======================

    public <T> void setCacheSet(final String key, final Set<T> dataSet) {
        try {
            Iterator<T> it = dataSet.iterator();
            while (it.hasNext()) {
                redisTemplate.opsForSet().add(key,it.next());
            }
        } catch (Exception e) {
            log.warn("Redis服务异常");
        }
    }

    public <T> void setCacheSet(final String key, final Set<T> dataSet, final Long time, final TimeUnit unit) {
        try {
            Iterator<T> it = dataSet.iterator();
            while (it.hasNext()) {
                redisTemplate.opsForSet().add(key,it.next());
            }
            redisTemplate.expire(key,time,unit);
        } catch (Exception e) {
            log.warn("Redis服务异常");
        }
    }

    public Set<Object> getCacheSet(final String key) {
        try {
            return redisTemplate.opsForSet().members(key);
        } catch (Exception e) {
            log.warn("Redis服务异常");
        }
        return null;
    }

    // =================ZSet类型操作=======================

    public void setCacheZSet(final String key,final Set<SortedSetData> dataSet) {
        try {
            Iterator<SortedSetData> it = dataSet.iterator();
            while (it.hasNext()) {
                SortedSetData data = it.next();
                redisTemplate.opsForZSet().add(key,data.getData(),data.getScore());
            }
        } catch (Exception e) {
            log.warn("Redis服务异常");
        }
    }

    public void setCacheZSet(final String key,final Set<SortedSetData> dataSet,final Long time,final TimeUnit unit) {
        try {
            Iterator<SortedSetData> it = dataSet.iterator();
            while (it.hasNext()) {
                SortedSetData data = it.next();
                redisTemplate.opsForZSet().add(key,data.getData(),data.getScore());
            }
            redisTemplate.expire(key,time,unit);
        } catch (Exception e) {
            log.warn("Redis服务异常");
        }
    }

    public <T> void setCacheZSetValue(final String key,final T value,final double score) {
        try {
            redisTemplate.opsForZSet().add(key,value,score);
        } catch (Exception e){
            log.warn("Redis服务异常");
        }
    }

    public Set<Object> getCacheZSet(final String key) {
        try {
            Set<Object> result = redisTemplate.opsForZSet().range(key, 0, -1);
            return result;
        } catch (Exception e){
            log.warn("Redis服务异常");
        }
        return null;
    }
}

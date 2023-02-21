package com.frankzhou.redis.cache;

import lombok.Data;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 设置逻辑过期时间
 * @date 2023-02-02
 */
@Data
public class RedisData {
    private String expireTime;
    private Object data;
}

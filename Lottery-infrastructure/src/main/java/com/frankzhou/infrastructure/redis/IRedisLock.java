package com.frankzhou.infrastructure.redis;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description Redis分布式锁基础办
 * @date 2023-02-02
 */
public interface IRedisLock {

    /**
     * 尝试获取锁
     *
     * @author this.FrankZhou
     * @param timeSec 上锁事件
     * @return true->成功/false->失败
     */
    boolean tryLock(Long timeSec);

    /**
     * 释放锁
     *
     * @author this.FrankZhou
     * @return void
     */
    void unlock();
}

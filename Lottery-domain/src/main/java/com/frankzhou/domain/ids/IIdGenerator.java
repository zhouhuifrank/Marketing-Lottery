package com.frankzhou.domain.ids;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description Id生成器接口
 * @date 2023-02-02
 */
public interface IIdGenerator {

    /**
     * 生成下一个唯一Id
     * 目前支持算法：
     * 雪花算法 生成单号
     * redis自增算法 生成全局唯一Id
     * 日期算法 生成活动编号
     * 随机算法 生成策略Id
     *
     * @author this.FrankZhou
     * @return 生成的Id
     */
    Long nextId();
}

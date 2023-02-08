package com.frankzhou.common.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
* @Author: this.FrankZhou
* @Description: 抽奖策略枚举类
* @DateTime: 2023/1/12 23:10
*/
@Getter
@AllArgsConstructor
public enum AlgorithmConstants {

    DEFAULT_RATE(1,"总体概率算法"),
    SINGLE_RATE(2,"单体概率算法");

    private final Integer strategyId;

    private final String strategyName;
}

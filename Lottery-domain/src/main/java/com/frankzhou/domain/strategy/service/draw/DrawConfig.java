package com.frankzhou.domain.strategy.service.draw;

import com.frankzhou.common.constants.AlgorithmType;
import com.frankzhou.domain.strategy.service.algorithm.IDrawAlgorithm;
import com.frankzhou.domain.strategy.service.algorithm.impl.EntiretyRateDrawAlgorithm;
import com.frankzhou.domain.strategy.service.algorithm.impl.SingleRateDrawAlgorithm;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 抽奖配置类 策略模式使用
 * @date 2023-02-02
 */
public class DrawConfig {

    @Resource
    EntiretyRateDrawAlgorithm entiretyRateDrawAlgorithm;

    @Resource
    SingleRateDrawAlgorithm singleRateDrawAlgorithm;

    public Map<Integer, IDrawAlgorithm> algorithmMap = new ConcurrentHashMap<>();

    @PostConstruct
    public void init() {
        algorithmMap.put(AlgorithmType.DEFAULT_RATE.getStrategyId(),singleRateDrawAlgorithm);
        algorithmMap.put(AlgorithmType.DEFAULT_RATE.getStrategyId(),entiretyRateDrawAlgorithm);
    }
}

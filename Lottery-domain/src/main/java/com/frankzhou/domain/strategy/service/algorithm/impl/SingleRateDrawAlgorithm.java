package com.frankzhou.domain.strategy.service.algorithm.impl;

import com.frankzhou.domain.strategy.service.algorithm.AbstractAlgorithmBase;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 单体概率算法
 * @date 2023-02-02
 */
@Component("singleRateDrawAlgorithm")
public class SingleRateDrawAlgorithm extends AbstractAlgorithmBase {

    private static final String NO_AWARD = "感谢参与";

    @Override
    public String randomDraw(Long strategyId, List<String> excludeAwardIdList) {
        if (!rateHashArrayMap.containsKey(strategyId)) {
            return NO_AWARD;
        }

        String[] rateArray = rateHashArrayMap.get(strategyId);

        // 直接散列，随机数->奖品id
        // 得到一个随机的散列值
        int randomNumber = super.getRandomNumber(100);
        int hashIndex = super.getHashIndex(randomNumber);
        // 返回结果
        String awardId = rateArray[hashIndex];
        // 判断是否是排除掉的奖品
        if (excludeAwardIdList.contains(awardId)) {
            return NO_AWARD;
        }

        return awardId;
    }
}

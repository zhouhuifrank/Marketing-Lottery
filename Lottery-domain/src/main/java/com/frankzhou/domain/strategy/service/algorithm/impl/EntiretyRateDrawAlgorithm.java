package com.frankzhou.domain.strategy.service.algorithm.impl;

import com.frankzhou.domain.strategy.model.vo.AwardRateVO;
import com.frankzhou.domain.strategy.service.algorithm.AbstractAlgorithmBase;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 总体概率算法
 * @date 2023-02-02
 */
@Component("entiretyRateDrawAlgorithm")
public class EntiretyRateDrawAlgorithm extends AbstractAlgorithmBase {

    private static final String NO_AWARD = "感谢参与";

    @Override
    public String randomDraw(Long strategyId, List<String> excludeAwardIdList) {
        if (!rateInfoMap.containsKey(strategyId)) {
            return NO_AWARD;
        }

        List<AwardRateVO> awardRateVOList = rateInfoMap.get(strategyId);
        BigDecimal cumRate = BigDecimal.ZERO;
        List<AwardRateVO> availableAwardList = new ArrayList<>();
        // 去掉排除的奖品
        Map<String,Integer> awardIdMap = new HashMap<>();
        excludeAwardIdList.forEach(key -> {
            awardIdMap.put(key,1);
        });

        for (AwardRateVO awardRateVO : awardRateVOList) {
            String awardId = awardRateVO.getAwardId();
            if (awardIdMap.containsKey(awardId)) {
                continue;
            }
            availableAwardList.add(awardRateVO);
            cumRate = cumRate.add(awardRateVO.getAwardRate());
        }

        // 排除不需要进行抽奖计算的
        if (availableAwardList.size() == 0) {
            return NO_AWARD;
        }
        if (availableAwardList.size() == 1) {
            return awardRateVOList.get(0).getAwardId();
        }

        int randomNumber = this.getRandomNumber(100);

        int prevPos = 0;
        String resultAwardId = "";
        for (AwardRateVO awardRateVO : availableAwardList) {
            // currPos可以转换为0-100之间的数
            int currPos = awardRateVO.getAwardRate().divide(cumRate,2, RoundingMode.HALF_UP).multiply(new BigDecimal(100)).intValue();
            if (randomNumber < (prevPos+currPos)) {
                resultAwardId = awardRateVO.getAwardId();
                break;
            }
            prevPos += currPos;
        }

        return resultAwardId;
    }
}

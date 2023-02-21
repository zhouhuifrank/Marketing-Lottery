package com.frankzhou.domain.strategy.service.draw.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.frankzhou.domain.strategy.service.algorithm.IDrawAlgorithm;
import com.frankzhou.domain.strategy.service.draw.AbstractDrawBase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 抽奖接口实现类
 * @date 2023-02-02
 */
@Slf4j
@Service("drawExecute")
public class DrawExecuteImpl extends AbstractDrawBase {

    @Override
    protected List<String> queryExcludeAwardList(Long strategyId) {
        List<String> awardIdList = strategyRepository.queryExcludeAwardIdList(strategyId);
        log.info("查询到已经排除物品,strategyId:{},awardList:{}",strategyId, JSONUtil.toJsonStr(awardIdList));
        // TODO 目前只排除没有库存的奖品，后续可能有风控规则或者临时调整规定
        return awardIdList;
    }

    @Override
    protected String drawAlgorithm(Long strategyId, IDrawAlgorithm drawAlgorithm, List<String> excludeAwardList) {
        String awardId = drawAlgorithm.randomDraw(strategyId, excludeAwardList);

        if (StrUtil.isBlank(awardId)) {
            return null;
        }

        // 扣减库存
        boolean isSuccess = strategyRepository.deductStock(strategyId, awardId);
        return isSuccess == true ? awardId : null;
    }
}

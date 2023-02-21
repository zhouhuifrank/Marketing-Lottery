package com.frankzhou.domain.strategy.service.draw;

import com.frankzhou.domain.strategy.model.aggregates.StrategyRich;
import com.frankzhou.domain.strategy.model.vo.AwardBriefVO;
import com.frankzhou.domain.strategy.model.vo.StrategyBfiefVO;
import com.frankzhou.domain.strategy.model.vo.StrategyDetailBriefVO;
import com.frankzhou.domain.strategy.repository.IStrategyRepository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 抽奖策略数据支撑类 提供通用的数据服务
 * @date 2023-02-02
 */
public class DrawSupport extends DrawConfig {

    @Resource
    protected IStrategyRepository strategyRepository;

    /**
     * 查询策略聚合信息 返回策略聚合对象
     *
     * @author this.FrankZhou
     * @param strategyId 策略Id
     * @return 策略聚合对象
     */
    protected StrategyRich queryStrategyRich(Long strategyId) {
        StrategyBfiefVO strategyVO = strategyRepository.queryStrategyVO(strategyId);
        List<StrategyDetailBriefVO> strategyDetailVOList = strategyRepository.queryStrategyDetailList(strategyId);
        StrategyRich strategyRich = StrategyRich
                .builder()
                .strategyVo(strategyVO)
                .strategyDetailList(strategyDetailVOList)
                .build();
        return null;
    }

    /**
     * 查询奖品信息 组装中奖结果
     *
     * @author this.FrankZhou
     * @param awardId 奖品Id
     * @return 中奖信息
     */
    protected AwardBriefVO queryAwardInfoByAwardId(String awardId) {
        AwardBriefVO awardVo = strategyRepository.queryAwardInfoByAwardId(awardId);
        return awardVo;
    }
}

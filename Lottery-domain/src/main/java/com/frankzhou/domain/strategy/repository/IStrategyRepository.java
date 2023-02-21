package com.frankzhou.domain.strategy.repository;


import com.frankzhou.domain.strategy.model.vo.AwardBriefVO;
import com.frankzhou.domain.strategy.model.vo.DrawAwardBriefVO;
import com.frankzhou.domain.strategy.model.vo.StrategyBfiefVO;
import com.frankzhou.domain.strategy.model.vo.StrategyDetailBriefVO;

import java.util.List;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description
 * @date 2023-02-02
 */
public interface IStrategyRepository {

    AwardBriefVO queryAwardInfoByAwardId(String awardId);

    DrawAwardBriefVO queryDrawAwardByAwardId(Long strategyId,String awardId,String uId);

    StrategyBfiefVO queryStrategyVO(Long strategyId);

    List<StrategyDetailBriefVO> queryStrategyDetailList(Long strategyId);

    List<String> queryExcludeAwardIdList(Long strategyId);

    boolean deductStock(Long strategyId,String awardId);
}

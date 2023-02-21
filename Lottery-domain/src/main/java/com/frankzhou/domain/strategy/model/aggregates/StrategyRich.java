package com.frankzhou.domain.strategy.model.aggregates;

import com.frankzhou.domain.strategy.model.vo.StrategyDetailBriefVO;
import com.frankzhou.domain.strategy.model.vo.StrategyBfiefVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 策略信息聚合对象
 * @date 2023-02-19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StrategyRich {

    private Long strategyId;

    private StrategyBfiefVO strategyVo;

    private List<StrategyDetailBriefVO> strategyDetailList;
}

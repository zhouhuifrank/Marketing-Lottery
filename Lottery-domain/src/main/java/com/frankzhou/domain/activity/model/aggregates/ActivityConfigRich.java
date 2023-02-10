package com.frankzhou.domain.activity.model.aggregates;

import com.frankzhou.domain.activity.model.vo.ActivityVO;
import com.frankzhou.domain.activity.model.vo.AwardVO;
import com.frankzhou.domain.activity.model.vo.StrategyDetailVO;
import com.frankzhou.domain.activity.model.vo.StrategyVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description
 * @date 2023-02-11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityConfigRich {

    private ActivityVO activity;

    private List<AwardVO> awardList;

    private List<StrategyDetailVO> strategyDetailList;
}

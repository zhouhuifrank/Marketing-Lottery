package com.frankzhou.domain.activity.repository;

import com.frankzhou.domain.activity.model.vo.ActivityVO;
import com.frankzhou.domain.activity.model.vo.AwardVO;
import com.frankzhou.domain.activity.model.vo.StrategyDetailVO;
import com.frankzhou.domain.activity.model.vo.StrategyVO;

import java.util.List;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 活动配置、状态流程仓储服务接口
 * @date 2023-02-02
 */
public interface IActivityRepository {

    /**
     * 添加活动信息
     *
     * @author this.FrankZhou
     * @param activityVO 活动信息
     * @return void
     */
    void addActivity(ActivityVO activityVO);

    /**
     * 添加奖品列表
     *
     * @author this.FrankZhou
     * @param awardVOList 奖品信息列表
     * @return void
     */
    void addAwardList(List<AwardVO> awardVOList);

    /**
     * 添加策略配置信息
     *
     * @author this.FrankZhou
     * @param strategy 策略信息
     * @return void
     */
    void addStrategy(StrategyVO strategy);

    /**
     * 添加策略明细列表
     *
     * @author this.FrankZhou
     * @param strategyDetailVOList 策略明细列表
     * @return void
     */
    void addStrategyDetailList(List<StrategyDetailVO> strategyDetailVOList);
}

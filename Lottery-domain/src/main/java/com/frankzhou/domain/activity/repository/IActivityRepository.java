package com.frankzhou.domain.activity.repository;

import com.frankzhou.common.constants.ActivityState;
import com.frankzhou.domain.activity.model.vo.*;

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
     * @return true新增成功/false新增失败
     */
    boolean addActivity(ActivityVO activityVO);

    /**
     * 添加奖品列表
     *
     * @author this.FrankZhou
     * @param awardVOList 奖品信息列表
     * @return true新增成功/false新增失败
     */
    boolean addAwardList(List<AwardVO> awardVOList);

    /**
     * 添加策略配置信息
     *
     * @author this.FrankZhou
     * @param strategy 策略信息
     * @return true新增成功/false新增失败
     */
    boolean addStrategy(StrategyVO strategy);

    /**
     * 添加策略明细列表
     *
     * @author this.FrankZhou
     * @param strategyDetailVOList 策略明细列表
     * @return true新增成功/false新增失败
     */
    boolean addStrategyDetailList(List<StrategyDetailVO> strategyDetailVOList);

    /**
     * 变更活动状态
     *
     * @author this.FrankZhou
     * @param activityId 活动号
     * @param currentSate 当前状态
     * @param afterState 下一个状态
     * @return true->变更状态成功/false->变更状态失败
     */
    boolean alterActivityState(Long activityId, ActivityState currentSate, ActivityState afterState);
}

package com.frankzhou.domain.activity.service.stateflow;

import com.frankzhou.common.constants.ActivityState;
import com.frankzhou.common.result.Result;
import com.frankzhou.domain.activity.repository.IActivityRepository;

import javax.annotation.Resource;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 状态流转抽象类
 * @date 2023-02-02
 */
public abstract class AbstractStateBase {

    @Resource
    protected IActivityRepository activityRepository;

    /**
     * 提审状态
     *
     * @author this.FrankZhou
     * @param activityId 活动号
     * @param currentState 当前状态
     * @return 响应码
     */
    public abstract Result arraignment(Long activityId, ActivityState currentState);

    /**
     * 撤审状态
     *
     * @author this.FrankZhou
     * @param activityId 活动号
     * @param currentState 当前状态
     * @return 响应码
     */
    public abstract Result checkRevoke(Long activityId, ActivityState currentState);

    /**
     * 审核通过状态
     *
     * @author this.FrankZhou
     * @param activityId 活动号
     * @param currentState 当前状态
     * @return 响应码
     */
    public abstract Result checkPass(Long activityId, ActivityState currentState);

    /**
     * 审核拒绝状态
     *
     * @author this.FrankZhou
     * @param activityId 活动号
     * @param currentState 当前状态
     * @return 响应码
     */
    public abstract Result checkRefuse(Long activityId, ActivityState currentState);

    /**
     * 活动进行中
     *
     * @author this.FrankZhou
     * @param activityId 活动号
     * @param currentState 当前状态
     * @return 响应码
     */
    public abstract Result doing(Long activityId, ActivityState currentState);

    /**
     * 活动关闭状态
     *
     * @author this.FrankZhou
     * @param activityId 活动号
     * @param currentState 当前状态
     * @return 响应码
     */
    public abstract Result close(Long activityId, ActivityState currentState);

    /**
     * 活动开启状态
     *
     * @author this.FrankZhou
     * @param activityId 活动号
     * @param currentState 当前状态
     * @return 响应码
     */
    public abstract Result open(Long activityId, ActivityState currentState);

}

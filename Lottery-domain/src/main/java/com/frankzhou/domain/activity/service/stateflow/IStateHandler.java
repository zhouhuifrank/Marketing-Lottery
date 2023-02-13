package com.frankzhou.domain.activity.service.stateflow;

import com.frankzhou.common.constants.ActivityState;
import com.frankzhou.common.result.Result;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 状态流转接口
 * @date 2023-02-02
 */
public interface IStateHandler {

    /**
     * 提审状态
     *
     * @author this.FrankZhou
     * @param activityId 活动号
     * @param currentState 当前状态
     * @return 响应码
     */
    Result arraignment(Long activityId, ActivityState currentState);

    /**
     * 撤审状态
     *
     * @author this.FrankZhou
     * @param activityId 活动号
     * @param currentState 当前状态
     * @return 响应码
     */
    Result checkRevoke(Long activityId, ActivityState currentState);

    /**
     * 审核通过状态
     *
     * @author this.FrankZhou
     * @param activityId 活动号
     * @param currentState 当前状态
     * @return 响应码
     */
    Result checkPass(Long activityId, ActivityState currentState);

    /**
     * 审核拒绝状态
     *
     * @author this.FrankZhou
     * @param activityId 活动号
     * @param currentState 当前状态
     * @return 响应码
     */
    Result checkRefuse(Long activityId, ActivityState currentState);

    /**
     * 活动进行中
     *
     * @author this.FrankZhou
     * @param activityId 活动号
     * @param currentState 当前状态
     * @return 响应码
     */
    Result doing(Long activityId, ActivityState currentState);

    /**
     * 活动关闭状态
     *
     * @author this.FrankZhou
     * @param activityId 活动号
     * @param currentState 当前状态
     * @return 响应码
     */
    Result close(Long activityId, ActivityState currentState);

    /**
     * 活动开启状态
     *
     * @author this.FrankZhou
     * @param activityId 活动号
     * @param currentState 当前状态
     * @return 响应码
     */
    Result open(Long activityId, ActivityState currentState);
}

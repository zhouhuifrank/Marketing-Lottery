package com.frankzhou.domain.activity.service.stateflow.event;

import com.frankzhou.common.constants.ActivityState;
import com.frankzhou.common.result.Result;
import com.frankzhou.domain.activity.service.stateflow.AbstractStateBase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 活动进行中
 * @date 2023-02-02
 */
@Slf4j
@Component
public class DoingState extends AbstractStateBase {

    @Override
    public Result arraignment(Long activityId, ActivityState currentState) {
        return null;
    }

    @Override
    public Result checkRevoke(Long activityId, ActivityState currentState) {
        return null;
    }

    @Override
    public Result checkPass(Long activityId, ActivityState currentState) {
        return null;
    }

    @Override
    public Result checkRefuse(Long activityId, ActivityState currentState) {
        return null;
    }

    @Override
    public Result doing(Long activityId, ActivityState currentState) {
        return null;
    }

    @Override
    public Result close(Long activityId, ActivityState currentState) {
        return null;
    }

    @Override
    public Result open(Long activityId, ActivityState currentState) {
        return null;
    }
}

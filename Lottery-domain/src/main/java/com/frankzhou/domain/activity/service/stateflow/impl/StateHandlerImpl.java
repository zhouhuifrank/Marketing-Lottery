package com.frankzhou.domain.activity.service.stateflow.impl;

import com.frankzhou.common.constants.ActivityState;
import com.frankzhou.common.result.Result;
import com.frankzhou.domain.activity.service.stateflow.IStateHandler;
import com.frankzhou.domain.activity.service.stateflow.StateConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 状态流转接口实现类
 * @date 2023-02-02
 */
@Slf4j
@Service
public class StateHandlerImpl extends StateConfig implements IStateHandler {

    @Override
    public Result edit(Long activityId, ActivityState currentState) {
        return stateMap.get(currentState).edit(activityId,currentState);
    }

    @Override
    public Result arraignment(Long activityId, ActivityState currentState) {
        return stateMap.get(currentState).arraignment(activityId,currentState);
    }

    @Override
    public Result checkRevoke(Long activityId, ActivityState currentState) {
        return stateMap.get(currentState).checkRevoke(activityId,currentState);
    }

    @Override
    public Result checkPass(Long activityId, ActivityState currentState) {
        return stateMap.get(currentState).checkPass(activityId,currentState);
    }

    @Override
    public Result checkRefuse(Long activityId, ActivityState currentState) {
        return stateMap.get(currentState).checkRefuse(activityId,currentState);
    }

    @Override
    public Result doing(Long activityId, ActivityState currentState) {
        return stateMap.get(currentState).doing(activityId,currentState);
    }

    @Override
    public Result close(Long activityId, ActivityState currentState) {
        return stateMap.get(currentState).close(activityId,currentState);
    }

    @Override
    public Result open(Long activityId, ActivityState currentState) {
        return stateMap.get(currentState).open(activityId,currentState);
    }
}

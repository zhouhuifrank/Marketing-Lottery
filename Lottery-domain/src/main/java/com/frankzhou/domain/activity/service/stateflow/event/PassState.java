package com.frankzhou.domain.activity.service.stateflow.event;

import com.frankzhou.common.constants.ActivityState;
import com.frankzhou.common.constants.ResponseConstants;
import com.frankzhou.common.result.Result;
import com.frankzhou.domain.activity.service.stateflow.AbstractStateBase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 审核通过
 * @date 2023-02-02
 */
@Slf4j
@Component
public class PassState extends AbstractStateBase {

    @Override
    public Result edit(Long activityId, ActivityState currentState) {
        Result res = new Result(ResponseConstants.SUCCESS.getCode(), "活动已经审核通过，不能进行编辑");
        return res;
    }

    @Override
    public Result arraignment(Long activityId, ActivityState currentState) {
        Result res = new Result(ResponseConstants.SUCCESS.getCode(), "活动进行中，不能提审");
        return res;
    }

    @Override
    public Result checkRevoke(Long activityId, ActivityState currentState) {
        Result res = new Result(ResponseConstants.SUCCESS.getCode(), "活动进行中，不能撤审");
        return res;
    }

    @Override
    public Result checkPass(Long activityId, ActivityState currentState) {
        Result res = new Result(ResponseConstants.SUCCESS.getCode(), "活动进行中，不能审核通过");
        return res;
    }

    @Override
    public Result checkRefuse(Long activityId, ActivityState currentState) {
        Result res = new Result(ResponseConstants.SUCCESS.getCode(), "活动进行中，不能拒绝审核");
        return res;
    }

    @Override
    public Result doing(Long activityId, ActivityState currentState) {
        boolean isSuccess = activityRepository.alterActivityState(activityId,currentState,ActivityState.DOING);
        Result res = isSuccess == true ? new Result(ResponseConstants.SUCCESS.getCode(), "活动进行中")
                : new Result(ResponseConstants.UNKNOWN_ERROR.getCode(), "活动状态变更失败");
        return null;
    }

    @Override
    public Result close(Long activityId, ActivityState currentState) {
        boolean isSuccess = activityRepository.alterActivityState(activityId,currentState,ActivityState.CLOSE);
        Result res = isSuccess == true ? new Result(ResponseConstants.SUCCESS.getCode(), "活动关闭成功")
                : new Result(ResponseConstants.UNKNOWN_ERROR.getCode(), "活动状态变更失败");
        return null;
    }

    @Override
    public Result open(Long activityId, ActivityState currentState) {
        Result res = new Result(ResponseConstants.SUCCESS.getCode(), "活动进行中，不能重新开启");
        return res;
    }
}

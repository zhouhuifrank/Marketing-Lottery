package com.frankzhou.domain.activity.service.stateflow.event;

import com.frankzhou.common.constants.ActivityState;
import com.frankzhou.common.constants.ResponseConstants;
import com.frankzhou.common.result.Result;
import com.frankzhou.domain.activity.service.stateflow.AbstractStateBase;
import com.frankzhou.domain.strategy.service.algorithm.AbstractAlgorithmBase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 撤审状态
 * @date 2023-02-17
 */
@Slf4j
@Component
public class RevokeState extends AbstractStateBase {

    @Override
    public Result edit(Long activityId, ActivityState currentState) {
        boolean isSuccess = activityRepository.alterActivityState(activityId,currentState,ActivityState.EDIT);
        Result res = isSuccess == true ? new Result(ResponseConstants.SUCCESS.getCode(),"活动状态变成功编辑") :
                new Result(ResponseConstants.UNKNOWN_ERROR.getCode(), "活动状态变更失败");
        return res;
    }

    @Override
    public Result arraignment(Long activityId, ActivityState currentState) {
        Result res = new Result(ResponseConstants.SUCCESS.getCode(), "撤审状态不能提交审核");
        return res;
    }

    @Override
    public Result checkRevoke(Long activityId, ActivityState currentState) {
        Result res = new Result(ResponseConstants.SUCCESS.getCode(), "撤审状态不能重复撤审");
        return res;
    }

    @Override
    public Result checkPass(Long activityId, ActivityState currentState) {
        Result res = new Result(ResponseConstants.SUCCESS.getCode(), "撤审状态不能审批通过");
        return res;
    }

    @Override
    public Result checkRefuse(Long activityId, ActivityState currentState) {
        Result res = new Result(ResponseConstants.SUCCESS.getCode(), "撤审状态不能提交拒绝");
        return res;
    }

    @Override
    public Result doing(Long activityId, ActivityState currentState) {
        Result res = new Result(ResponseConstants.SUCCESS.getCode(), "撤审状态不能变更为进行种");
        return res;
    }

    @Override
    public Result close(Long activityId, ActivityState currentState) {
        Result res = new Result(ResponseConstants.SUCCESS.getCode(), "撤审状态不能关闭");
        return res;
    }

    @Override
    public Result open(Long activityId, ActivityState currentState) {
        Result res = new Result(ResponseConstants.SUCCESS.getCode(), "撤审状态不能提交开启");
        return res;
    }
}

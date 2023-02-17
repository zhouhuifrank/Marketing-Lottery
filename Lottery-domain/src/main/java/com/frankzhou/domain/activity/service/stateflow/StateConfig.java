package com.frankzhou.domain.activity.service.stateflow;

import com.frankzhou.common.constants.ActivityState;
import com.frankzhou.domain.activity.service.stateflow.event.*;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description
 * @date 2023-02-02
 */
public class StateConfig {

    @Resource
    private ArraignmentState arraignmentState;

    @Resource
    private CloseState closeState;

    @Resource
    private DoingState doingState;

    @Resource
    private EditingState editingState;

    @Resource
    private OpenState openState;

    @Resource
    private PassState passState;

    @Resource
    private RevokeState revokeState;

    @Resource
    private RefuseState refuseState;

    protected Map<ActivityState,AbstractStateBase> stateMap = new ConcurrentHashMap<>();

    @PostConstruct
    public void init() {
        stateMap.put(ActivityState.ARRAIGNMENT,arraignmentState);
        stateMap.put(ActivityState.CLOSE,closeState);
        stateMap.put(ActivityState.DOING,doingState);
        stateMap.put(ActivityState.EDIT,editingState);
        stateMap.put(ActivityState.REVOKE,revokeState);
        stateMap.put(ActivityState.OPEN,openState);
        stateMap.put(ActivityState.PASS,passState);
        stateMap.put(ActivityState.REFUSE,refuseState);
    }
}

package com.frankzhou.lottery.interfaces;

import com.frankzhou.common.constants.ResponseConstants;
import com.frankzhou.common.result.Result;
import com.frankzhou.infrastructure.entity.Activity;
import com.frankzhou.infrastructure.mapper.ActivityMapper;
import com.frankzhou.rpc.IActivityBooth;
import com.frankzhou.rpc.dto.ActivityDTO;
import com.frankzhou.rpc.req.ActivityReq;
import com.frankzhou.rpc.res.ActivityRes;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 活动服务RPC接口实现类
 * @date 2023-02-02
 */
@Slf4j
@DubboService
public class ActivityBooth implements IActivityBooth {

    @Resource
    private ActivityMapper activityMapper;

    @Override
    public ActivityRes queryActivityById(ActivityReq activityReq) {
        if (Objects.isNull(activityReq)) {
            return null;
        }

        Activity activity;
        Long activityId = activityReq.getActivityId();
        activity = activityMapper.queryActivityById(activityId);
        ActivityDTO targetDTO = ActivityDTO.
                builder().id(activity.getId())
                .activityName(activity.getActivityName())
                .activityDesc(activity.getActivityDesc())
                .beginDateTime(activity.getBeginDateTime())
                .endDateTime(activity.getEndDateTime())
                .stockCount(activity.getStockCount())
                .stockSurplusCount(activity.getStockSurplusCount())
                .takeCount(activity.getTakeCount())
                .build();

        return new ActivityRes(Result.getResult(ResponseConstants.SUCCESS),targetDTO);
    }
}

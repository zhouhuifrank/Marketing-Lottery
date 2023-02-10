package com.frankzhou.domain.activity.service.deploy.impl;

import com.frankzhou.domain.activity.model.req.ActivityConfigReq;
import com.frankzhou.domain.activity.repository.IActivityRepository;
import com.frankzhou.domain.activity.service.deploy.IActivityDeploy;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 活动配置实现类
 * @date 2023-02-02
 */
@Service
public class ActivityDeploy implements IActivityDeploy {

    @Resource
    private IActivityRepository activityRepository;

    @Override
    public void createActivity(ActivityConfigReq configReq) {

    }

    @Override
    public void updateActivity(ActivityConfigReq configReq) {

    }
}

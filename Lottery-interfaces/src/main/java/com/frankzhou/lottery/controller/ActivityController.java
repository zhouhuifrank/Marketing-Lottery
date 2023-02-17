package com.frankzhou.lottery.controller;

import com.frankzhou.rpc.IActivityService;
import com.frankzhou.rpc.req.ActivityReq;
import com.frankzhou.rpc.res.ActivityRes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description
 * @date 2023-02-17
 */
@Slf4j
@RestController
@RequestMapping("/activity")
public class ActivityController {

    @Resource
    private IActivityService activityBooth;

    @PostMapping("/queryActivityById")
    public ActivityRes queryActivityById(@RequestBody ActivityReq req) {
        ActivityRes activityRes = activityBooth.queryActivityById(req);
        return activityRes;
    }
}

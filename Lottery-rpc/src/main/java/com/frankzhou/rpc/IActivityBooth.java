package com.frankzhou.rpc;

import com.frankzhou.infrastructure.entity.Activity;
import com.frankzhou.rpc.req.ActivityReq;
import com.frankzhou.rpc.res.ActivityRes;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 活动服务RPC接口信息
 * @date 2023-02-02
 */
public interface IActivityBooth {

    /**
     * 根据活动id查询具体的活动信息
     *
     * @author this.FrankZhou
     * @param activityReq 活动信息请求参数
     * @return 活动信息响应值
     */
    ActivityRes queryActivityById(ActivityReq activityReq);
}

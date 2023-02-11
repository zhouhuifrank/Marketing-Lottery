package com.frankzhou.lottery.rpc;

import com.frankzhou.rpc.IActivityBooth;
import com.frankzhou.rpc.req.ActivityReq;
import com.frankzhou.rpc.res.ActivityRes;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description
 * @date 2023-02-09
 */
@SpringBootTest
public class ApiTest {

    @Resource
    private IActivityBooth activityBooth;

    @Test
    public void testQueryActivityById() {
        ActivityReq req = new ActivityReq();
        req.setActivityId(100003L);
        req.setUId("FrankZhou");

        ActivityRes activityRes = activityBooth.queryActivityById(req);
        System.out.println(activityRes);
    }
}

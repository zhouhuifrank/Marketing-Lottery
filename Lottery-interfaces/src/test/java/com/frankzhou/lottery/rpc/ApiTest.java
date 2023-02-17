package com.frankzhou.lottery.rpc;

import com.frankzhou.rpc.IActivityService;
import com.frankzhou.rpc.IAwardService;
import com.frankzhou.rpc.req.ActivityReq;
import com.frankzhou.rpc.req.AwardReq;
import com.frankzhou.rpc.res.ActivityRes;
import com.frankzhou.rpc.res.AwardRes;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description
 * @date 2023-02-09
 */
@SpringBootTest
public class ApiTest {

    @Resource
    private IActivityService activityService;

    @Resource
    private IAwardService awardService;

    @Test
    public void testQueryActivityById() {
        ActivityReq req = new ActivityReq();
        req.setActivityId(100003L);
        req.setUId("FrankZhou");

        ActivityRes activityRes = activityService.queryActivityById(req);
        System.out.println(activityRes);
    }

    @Test
    public void testQueryAwardByAwardType() {
        AwardReq req = new AwardReq();
        req.setAwardType(1);

        AwardRes awardRes = awardService.queryAwardByAwardType(req);
        System.out.println(awardRes);
    }

    @Test
    public void testHash() {
        List<Integer> arr = Arrays.asList(5,2,8,1,9,2,3);
        int position = 2;
        int count = 0;
        while (count < arr.size()) {
            System.out.println(arr.get(position));
            count++;
            position++;
            if (position == arr.size()) {
                position = 0;
            }
        }
    }
}

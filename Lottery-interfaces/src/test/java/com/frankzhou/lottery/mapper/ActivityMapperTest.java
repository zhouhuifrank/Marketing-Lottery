package com.frankzhou.lottery.mapper;

import com.frankzhou.domain.activity.model.vo.AlterStateVO;
import com.frankzhou.infrastructure.entity.Activity;
import com.frankzhou.infrastructure.mapper.ActivityMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description
 * @date 2023-02-09
 */
@SpringBootTest
public class ActivityMapperTest {

    @Resource
    private ActivityMapper activityMapper;

    @Test
    public void testQueryActivityById() {
        Long activityId = 100003L;
        Activity activity = activityMapper.queryActivityById(activityId);
        System.out.println(activity);
    }

    @Test
    public void testAlterState() {
        AlterStateVO alterStateVO = new AlterStateVO();
        alterStateVO.setActivityId(100004L);
        alterStateVO.setBeforeState(5);
        alterStateVO.setAfterState(1);
        Integer count = activityMapper.alterActivityState(alterStateVO);
        System.out.println(count);
    }

    @Test
    public void testInsertActivity() {
        Activity activity = Activity
                .builder()
                .activityId(100004L)
                .activityName("评价抽奖")
                .activityDesc("用户五星好评可以抽奖一次")
                .beginDateTime(LocalDateTime.now())
                .endDateTime(LocalDateTime.of(2024,1,1,12,00))
                .stockCount(1000)
                .stockSurplusCount(900)
                .takeCount(0)
                .strategyId(1002L)
                .state(5)
                .creator("frankzhou").build();

        Integer count = activityMapper.insertActivity(activity);
        System.out.println("插入数据:"+count);
    }
}

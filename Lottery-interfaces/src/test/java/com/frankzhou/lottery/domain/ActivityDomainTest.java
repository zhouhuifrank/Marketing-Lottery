package com.frankzhou.lottery.domain;

import com.alibaba.nacos.shaded.org.checkerframework.checker.units.qual.C;
import com.frankzhou.common.constants.ActivityState;
import com.frankzhou.domain.activity.model.aggregates.ActivityConfigRich;
import com.frankzhou.domain.activity.model.req.ActivityConfigReq;
import com.frankzhou.domain.activity.model.vo.ActivityVO;
import com.frankzhou.domain.activity.model.vo.AwardVO;
import com.frankzhou.domain.activity.model.vo.StrategyDetailVO;
import com.frankzhou.domain.activity.model.vo.StrategyVO;
import com.frankzhou.domain.activity.repository.IActivityRepository;
import com.frankzhou.domain.activity.service.deploy.IActivityDeploy;
import com.frankzhou.domain.activity.service.deploy.impl.ActivityDeploy;
import com.frankzhou.domain.activity.service.stateflow.IStateHandler;
import com.frankzhou.infrastructure.entity.Activity;
import com.frankzhou.infrastructure.entity.Award;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description
 * @date 2023-02-09
 */
@SpringBootTest
public class ActivityDomainTest {

    @Resource
    private IActivityDeploy activityDeploy;

    @Resource
    private IStateHandler stateHandler;

    @Resource
    private IActivityRepository activityRepository;

    private ActivityConfigReq configReq = new ActivityConfigReq();

    @Test
    public void testCreateActivity() {
        configReq.setActivityId(100004L);

        ActivityConfigRich configRich = new ActivityConfigRich();
        ActivityVO activity = ActivityVO
                .builder()
                .activityId(100004L)
                .activityName("斗鱼大司马直播抽奖")
                .activityDesc("直播抽5000元红包")
                .beginDateTime(LocalDateTime.now())
                .endDateTime(LocalDateTime.of(2024,3,21,12,0))
                .creator("大司马")
                .stockCount(5)
                .stockSurplusCount(5)
                .takeCount(0)
                .build();
        configRich.setActivity(activity);

        AwardVO award1 = AwardVO
                .builder()
                .build();

        AwardVO award2 = AwardVO
                .builder()
                .build();

        List<AwardVO> awardVOList = Arrays.asList(award1,award2);
        configRich.setAwardList(awardVOList);

        StrategyDetailVO detailVO1 = StrategyDetailVO.builder().build();

        StrategyDetailVO detailVO2 = StrategyDetailVO.builder().build();

        List<StrategyDetailVO> detailVOList = Arrays.asList(detailVO1,detailVO2);
        StrategyVO strategyVO = StrategyVO.builder().build();
    }

    @Test
    public void testAlterState() {
        Long activityId = 100004L;
        boolean isSuccess = activityRepository.alterActivityState(activityId, ActivityState.EDIT, ActivityState.PASS);
        if (isSuccess) {
            System.out.println("活动状态变更成功");
        } else {
            System.out.println("活动状态变更失败");
        }
    }
}

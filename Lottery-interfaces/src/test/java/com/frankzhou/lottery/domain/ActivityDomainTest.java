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
import java.math.BigDecimal;
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

    @Test
    public void testCreateActivity() {
        ActivityConfigReq configReq = new ActivityConfigReq();
        configReq.setActivityId(100005L);

        ActivityConfigRich configRich = new ActivityConfigRich();
        ActivityVO activity = ActivityVO
                .builder()
                .activityId(100005L)
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
                .awardId("9")
                .awardType(2)
                .awardName("赛博顶真")
                .awardContent("纯真顶针").build();

        AwardVO award2 = AwardVO
                .builder()
                .awardId("10")
                .awardType(2)
                .awardName("理塘牛肉")
                .awardContent("好吃").build();
        AwardVO award3 = AwardVO
                .builder()
                .awardId("11")
                .awardType(2)
                .awardName("保温杯")
                .awardContent("最新高科技保温杯").build();

        List<AwardVO> awardVOList = Arrays.asList(award1,award2,award3);
        configRich.setAwardList(awardVOList);

        StrategyDetailVO detailVO1 = StrategyDetailVO
                .builder()
                .strategyId(10003L)
                .awardId("9")
                .awardName("赛博顶真")
                .awardCount(1)
                .awardSurplusCount(1)
                .awardRate(BigDecimal.valueOf(0.01))
                .build();

        StrategyDetailVO detailVO2 = StrategyDetailVO
                .builder()
                .strategyId(10003L)
                .awardId("10")
                .awardName("理塘牛肉")
                .awardCount(10)
                .awardSurplusCount(9)
                .awardRate(BigDecimal.valueOf(0.2))
                .build();

        StrategyDetailVO detailVO3 = StrategyDetailVO
                .builder()
                .strategyId(10003L)
                .awardId("11")
                .awardName("保温杯")
                .awardCount(100)
                .awardSurplusCount(100)
                .awardRate(BigDecimal.valueOf(0.01))
                .build();

        List<StrategyDetailVO> detailVOList = Arrays.asList(detailVO1,detailVO2,detailVO3);

        StrategyVO strategyVO = StrategyVO
                .builder()
                .strategyId(10003L)
                .strategyDesc("天涯明月刀")
                .strategyMode(1)
                .grantType(3)
                .strategyDetailList(detailVOList)
                .build();
        configRich.setStrategy(strategyVO);

        configReq.setActivityConfigRich(configRich);
        activityDeploy.createActivity(configReq);
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

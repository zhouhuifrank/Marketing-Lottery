package com.frankzhou.domain.activity.service.deploy.impl;

import cn.hutool.json.JSONUtil;
import com.frankzhou.domain.activity.model.aggregates.ActivityConfigRich;
import com.frankzhou.domain.activity.model.req.ActivityConfigReq;
import com.frankzhou.domain.activity.model.vo.ActivityVO;
import com.frankzhou.domain.activity.model.vo.AwardVO;
import com.frankzhou.domain.activity.model.vo.StrategyDetailVO;
import com.frankzhou.domain.activity.model.vo.StrategyVO;
import com.frankzhou.domain.activity.repository.IActivityRepository;
import com.frankzhou.domain.activity.service.deploy.IActivityDeploy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 活动配置实现类
 * @date 2023-02-02
 */
@Slf4j
@Service
public class ActivityDeploy implements IActivityDeploy {

    @Resource
    private IActivityRepository activityRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createActivity(ActivityConfigReq configReq) {
        Long activityId = configReq.getActivityId();
        log.info("正在创建活动配置:{}",activityId);
        ActivityConfigRich configRich = configReq.getActivityConfigRich();
        try {
            ActivityVO activity = configRich.getActivity();
            boolean flag1 = activityRepository.addActivity(activity);
            if (!flag1) {
                throw new RuntimeException("数据库插入异常");
            }

            List<AwardVO> awardList = configRich.getAwardList();
            boolean flag2 = activityRepository.addAwardList(awardList);
            if (!flag2) {
                throw new RuntimeException("数据库插入异常");
            }

            StrategyVO strategy = configRich.getStrategy();
            boolean flag3 = activityRepository.addStrategy(strategy);
            if (!flag3) {
                throw new RuntimeException("数据库插入异常");
            }

            List<StrategyDetailVO> strategyDetailList = configRich.getStrategy().getStrategyDetailList();
            boolean flag4 = activityRepository.addStrategyDetailList(strategyDetailList);
            if (!flag4) {
                throw new RuntimeException("数据库插入异常");
            }
            log.info("活动配置创建完成:{}",activityId);
        } catch (Exception e) {
            log.warn("数据库异常，活动配置创建失败，活动:{},异常信息:{}",activityId, e.getMessage());
            throw e;
        }
    }

    @Override
    public void updateActivity(ActivityConfigReq configReq) {
        log.info("TODO 非核心功能，待项目大体完成进行开发");
    }
}

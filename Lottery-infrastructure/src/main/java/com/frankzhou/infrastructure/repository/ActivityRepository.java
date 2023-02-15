package com.frankzhou.infrastructure.repository;

import cn.hutool.core.bean.BeanUtil;
import com.frankzhou.common.constants.ActivityState;
import com.frankzhou.domain.activity.model.vo.*;
import com.frankzhou.domain.activity.repository.IActivityRepository;
import com.frankzhou.infrastructure.entity.Activity;
import com.frankzhou.infrastructure.entity.Award;
import com.frankzhou.infrastructure.entity.Strategy;
import com.frankzhou.infrastructure.entity.StrategyDetail;
import com.frankzhou.infrastructure.mapper.ActivityMapper;
import com.frankzhou.infrastructure.mapper.AwardMapper;
import com.frankzhou.infrastructure.mapper.StrategyDetailMapper;
import com.frankzhou.infrastructure.mapper.StrategyMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 活动仓储服务实现类
 * @date 2023-02-02
 */
@Repository
public class ActivityRepository implements IActivityRepository {

    @Resource
    private ActivityMapper activityMapper;

    @Resource
    private AwardMapper awardMapper;

    @Resource
    private StrategyMapper strategyMapper;

    @Resource
    private StrategyDetailMapper strategyDetailMapper;

    @Override
    public boolean addActivity(ActivityVO activityVO) {
        Activity activity = new Activity();
        BeanUtil.copyProperties(activityVO,activity);
        Integer count = activityMapper.insertActivity(activity);
        if (count < 1) {
            return false;
        }
        return true;
    }

    @Override
    public boolean addAwardList(List<AwardVO> awardVOList) {
        List<Award> awardList = new ArrayList<>();
        for (AwardVO vo:awardVOList) {
            Award award = new Award();
            BeanUtil.copyProperties(vo,award);
            awardList.add(award);
        }
        Integer count = awardMapper.batchInsert(awardList);
        if (count != awardList.size()) {
            return false;
        }
        return true;
    }

    @Override
    public boolean addStrategy(StrategyVO strategyVO) {
        Strategy strategy = new Strategy();
        BeanUtil.copyProperties(strategyVO,strategy);
        Integer count = strategyMapper.insertStrategy(strategy);
        if (count < 1) {
            return false;
        }
        return true;
    }

    @Override
    public boolean addStrategyDetailList(List<StrategyDetailVO> strategyDetailVOList) {
        List<StrategyDetail> strategyDetailList = new ArrayList<>();
        for (StrategyDetailVO vo:strategyDetailVOList) {
            StrategyDetail strategyDetail = new StrategyDetail();
            BeanUtil.copyProperties(vo,strategyDetail);
            strategyDetailList.add(strategyDetail);
        }
        Integer count = strategyDetailMapper.batchInsert(strategyDetailList);
        if (count != strategyDetailList.size()) {
            return false;
        }
        return true;
    }

    @Override
    public boolean alterActivityState(Long activityId, Enum<ActivityState> beforeState, Enum<ActivityState> afterState) {
        AlterStateVO alterStateVO = new AlterStateVO(activityId,((ActivityState)beforeState).getCode(),((ActivityState)afterState).getCode());
        Integer count = activityMapper.alterActivityState(alterStateVO);
        if (count < 1) {
            return false;
        }
        return true;
    }

}

package com.frankzhou.infrastructure.repository;

import com.frankzhou.domain.activity.model.vo.ActivityVO;
import com.frankzhou.domain.activity.model.vo.AwardVO;
import com.frankzhou.domain.activity.model.vo.StrategyDetailVO;
import com.frankzhou.domain.activity.model.vo.StrategyVO;
import com.frankzhou.domain.activity.repository.IActivityRepository;
import com.frankzhou.infrastructure.mapper.ActivityMapper;
import com.frankzhou.infrastructure.mapper.AwardMapper;
import com.frankzhou.infrastructure.mapper.StrategyDetailMapper;
import com.frankzhou.infrastructure.mapper.StrategyMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
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
    public void addActivity(ActivityVO activityVO) {

    }

    @Override
    public void addAwardList(List<AwardVO> awardVOList) {

    }

    @Override
    public void addStrategy(StrategyVO strategy) {

    }

    @Override
    public void addStrategyDetailList(List<StrategyDetailVO> strategyDetailVOList) {

    }
}

package com.frankzhou.infrastructure.repository;

import cn.hutool.core.bean.BeanUtil;
import com.frankzhou.domain.strategy.model.vo.AwardBriefVO;
import com.frankzhou.domain.strategy.model.vo.DrawAwardBriefVO;
import com.frankzhou.domain.strategy.model.vo.StrategyBfiefVO;
import com.frankzhou.domain.strategy.model.vo.StrategyDetailBriefVO;
import com.frankzhou.domain.strategy.repository.IStrategyRepository;
import com.frankzhou.infrastructure.entity.Award;
import com.frankzhou.infrastructure.entity.Strategy;
import com.frankzhou.infrastructure.entity.StrategyDetail;
import com.frankzhou.infrastructure.mapper.AwardMapper;
import com.frankzhou.infrastructure.mapper.StrategyDetailMapper;
import com.frankzhou.infrastructure.mapper.StrategyMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 策略仓储服务实现类
 * @date 2023-02-02
 */
@Repository
public class StrategyRepository implements IStrategyRepository {

    @Resource
    private AwardMapper awardMapper;

    @Resource
    private StrategyMapper strategyMapper;

    @Resource
    private StrategyDetailMapper strategyDetailMapper;

    @Override
    public AwardBriefVO queryAwardInfoByAwardId(String awardId) {
        Award award = awardMapper.queryAwardByAwardId(awardId);
        AwardBriefVO awardVO = new AwardBriefVO();
        BeanUtil.copyProperties(award,awardVO);
        return awardVO;
    }

    @Override
    public DrawAwardBriefVO queryDrawAwardByAwardId(Long strategyId, String awardId, String uId) {
        DrawAwardBriefVO awardBriefVO = new DrawAwardBriefVO();
        Award award = awardMapper.queryAwardByAwardId(awardId);
        Strategy strategy = strategyMapper.queryStrategyById(strategyId);
        awardBriefVO.setUId(uId);
        awardBriefVO.setAwardId(awardId);
        awardBriefVO.setAwardName(award.getAwardName());
        awardBriefVO.setAwardType(award.getAwardType());
        awardBriefVO.setAwardContent(award.getAwardContent());
        awardBriefVO.setStrategyMode(strategy.getStrategyMode());
        awardBriefVO.setGrantType(strategy.getGrantType());
        awardBriefVO.setGrantDate(strategy.getGrantDate());
        return awardBriefVO;
    }

    @Override
    public StrategyBfiefVO queryStrategyVO(Long strategyId) {
        Strategy strategy = strategyMapper.queryStrategyById(strategyId);
        StrategyBfiefVO strategyVO = new StrategyBfiefVO();
        BeanUtil.copyProperties(strategy,strategyVO);
        return strategyVO;
    }

    @Override
    public List<StrategyDetailBriefVO> queryStrategyDetailList(Long strategyId) {
        List<StrategyDetail> strategyDetailList = strategyDetailMapper.queryStrategyListById(strategyId);
        List<StrategyDetailBriefVO> strategyDetailVOList = new ArrayList<>();
        for (StrategyDetail detail : strategyDetailList) {
            StrategyDetailBriefVO detailVO = new StrategyDetailBriefVO();
            BeanUtil.copyProperties(detail,detailVO);
            strategyDetailVOList.add(detailVO);
        }
        return strategyDetailVOList;
    }

    @Override
    public List<String> queryExcludeAwardIdList(Long strategyId) {
        List<StrategyDetail> strategyDetailList = strategyDetailMapper.queryNoStockAward(strategyId);
        List<String> awardIdList = strategyDetailList.stream().
                map(StrategyDetail::getAwardId).
                collect(Collectors.toList());
        return awardIdList;
    }

    @Override
    public boolean deductStock(Long strategyId, String awardId) {
        Integer count = strategyDetailMapper.deductStock(strategyId, awardId);
        if (count < 1) {
            return false;
        }
        return true;
    }
}

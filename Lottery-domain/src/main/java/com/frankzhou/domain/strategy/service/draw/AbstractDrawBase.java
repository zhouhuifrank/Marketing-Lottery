package com.frankzhou.domain.strategy.service.draw;


import com.frankzhou.common.constants.DrawState;
import com.frankzhou.domain.strategy.model.aggregates.StrategyRich;
import com.frankzhou.domain.strategy.model.req.DrawReq;
import com.frankzhou.domain.strategy.model.res.DrawResult;
import com.frankzhou.domain.strategy.model.vo.*;
import com.frankzhou.domain.strategy.repository.IStrategyRepository;
import com.frankzhou.domain.strategy.service.algorithm.IDrawAlgorithm;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 定义抽象抽奖过程 应用模板模式
 * @date 2023-02-02
 */
@Slf4j
public abstract class AbstractDrawBase extends DrawSupport implements IDrawExecute {

    @Resource
    protected IStrategyRepository strategyRepository;

    /**
     * 模板模式 处理标准化业务流程
     * 在一般的service之上在抽出一层抽奖类，继承对应接口，按照业务流程定义出整个流程
     * 每一个步骤基本可以定义出一个方法，将公共的方法实现放在该抽象类中，需要具体实现的方法交给子类进行实现
     * 使用这种方法整体的业务流程清晰，容易进行维护
     *
     * @author this.FrankZhou
     * @param req 抽奖请求参数
     * @return 抽奖包装结果
     */
    @Override
    public DrawResult doDrawAward(DrawReq req) {
        // 获取抽奖策略
        Long strategyId = req.getStrategyId();
        StrategyRich strategyRich = super.queryStrategyRich(strategyId);
        StrategyBfiefVO strategyVo = strategyRich.getStrategyVo();
        List<StrategyDetailBriefVO> strategyDetailList = strategyRich.getStrategyDetailList();

        // 校验抽奖策略概率hash数组是否已经初始化，若没有，则执行初始化方法
        this.checkAndInitHash(strategyId,strategyVo.getStrategyMode(),strategyDetailList);

        // 获取不在抽奖范围内的列表，包含：奖品库存为空、风控策略、临时业务调整
        List<String> excludeAwardList = this.queryExcludeAwardList(strategyId);

        // 执行抽奖算法
        IDrawAlgorithm drawAlgorithm = super.algorithmMap.get(strategyVo.getStrategyId());
        String awardId = drawAlgorithm(strategyId, drawAlgorithm, excludeAwardList);

        // 包装抽奖结果
        DrawResult drawResult = buildDrawResult(req.getUId(), strategyId, awardId);
        return drawResult;
    }

    /**
     * 排除不在抽奖范围内地列表
     *
     * @author this.FrankZhou
     * @param strategyId 策略Id
     * @return 排除掉地奖品Id集合
     */
    protected  abstract List<String> queryExcludeAwardList(Long strategyId);

    /**
     * 执行抽奖算法
     *
     * @author this.FrankZhou
     * @param strategyId 策略Id
     * @param drawAlgorithm 抽奖算法
     * @param excludeAwardList 排除地奖品Id列表
     * @return 中奖奖品Id 可能为空字符串
     */
    protected abstract String drawAlgorithm(Long strategyId, IDrawAlgorithm drawAlgorithm,List<String> excludeAwardList);

    private void checkAndInitHash(Long strategyId, Integer strategyMode, List<StrategyDetailBriefVO> strategyDetailList) {
        IDrawAlgorithm drawAlgorithm = super.algorithmMap.get(strategyMode);
        if (drawAlgorithm.isExist(strategyId)) {
            return;
        }

        List<AwardRateVO> awardRateVOList = new ArrayList<>();
        for (StrategyDetailBriefVO detailVO : strategyDetailList) {
            AwardRateVO rateVO = new AwardRateVO();
            rateVO.setAwardId(detailVO.getAwardId());
            rateVO.setAwardRate(detailVO.getAwardRate());
            awardRateVOList.add(rateVO);
        }

        try {
            drawAlgorithm.initRateHash(strategyId,strategyMode,awardRateVOList);
        } catch (InterruptedException e) {
            log.error("redis服务异常，分布式锁失败");
        }
    }

    private DrawResult buildDrawResult(String uId,Long strategyId,String awardId) {
        DrawResult drawResult = new DrawResult();
        drawResult.setStrategyId(strategyId);
        DrawAwardBriefVO awardBriefVO = strategyRepository.queryDrawAwardByAwardId(strategyId, awardId, uId);
        drawResult.setDrawAwardVO(awardBriefVO);
        drawResult.setUId(uId);
        drawResult.setDrawState(DrawState.SUCCESS.getCode());
        return drawResult;
    }
}

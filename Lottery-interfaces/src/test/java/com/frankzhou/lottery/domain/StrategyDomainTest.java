package com.frankzhou.lottery.domain;

import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.frankzhou.common.constants.AlgorithmType;
import com.frankzhou.domain.strategy.model.vo.AwardRateVO;
import com.frankzhou.domain.strategy.service.algorithm.IDrawAlgorithm;
import com.frankzhou.domain.strategy.service.draw.DrawConfig;
import com.frankzhou.infrastructure.entity.Award;
import com.frankzhou.infrastructure.entity.Strategy;
import com.frankzhou.infrastructure.entity.StrategyDetail;
import com.frankzhou.infrastructure.mapper.ActivityMapper;
import com.frankzhou.infrastructure.mapper.AwardMapper;
import com.frankzhou.infrastructure.mapper.StrategyDetailMapper;
import com.frankzhou.infrastructure.mapper.StrategyMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description
 * @date 2023-02-09
 */
@Slf4j
@SpringBootTest
public class StrategyDomainTest {

    @Resource
    private DrawConfig algorithmConfig;

    @Resource
    private AwardMapper awardMapper;

    @Resource
    private StrategyMapper strategyMapper;

    @Resource
    private StrategyDetailMapper strategyDetailMapper;

    @Test
    public void testBigDecimal() {
        BigDecimal number = BigDecimal.ZERO;
        number = number.add(new BigDecimal(0.85));
        BigDecimal d1 = new BigDecimal(0.25);
        int currRate = d1.divide(number,2,RoundingMode.HALF_UP).multiply(new BigDecimal(100)).intValue();
        System.out.println(currRate);
    }

    @Test
    public void testSingleRateAlgorithm() {
        Long strategyId = 10002L;
        List<AwardRateVO> excludeAwardRateList = new ArrayList<>();
        List<StrategyDetail> noStockDetailList = strategyDetailMapper.queryNoStockAward(strategyId);
        // 得到排除的奖品列表
        for (StrategyDetail strategyDetail : noStockDetailList) {
            AwardRateVO rateVO = AwardRateVO
                    .builder()
                    .awardId(strategyDetail.getAwardId())
                    .awardRate(strategyDetail.getAwardRate())
                    .build();
            excludeAwardRateList.add(rateVO);
        }
        log.info("本次抽奖排除的奖品为:{}",JSONUtil.toJsonStr(noStockDetailList));

        // 2. 查出strategyId对应的奖品列表
        List<StrategyDetail> awardDetailList = strategyDetailMapper.queryStrategyListById(strategyId);
        List<AwardRateVO> fullAwardRateList = new ArrayList<>();
        for (StrategyDetail strategyDetail : awardDetailList) {
            AwardRateVO rateVO = AwardRateVO
                    .builder()
                    .awardId(strategyDetail.getAwardId())
                    .awardRate(strategyDetail.getAwardRate())
                    .build();
            fullAwardRateList.add(rateVO);
        }

        // 3. 根据strategyId查出该策略属于那个抽奖算法
        Strategy strategy = strategyMapper.queryStrategyById(strategyId);
        Integer algorithmType = strategy.getGrantType();
        log.info("本次执行抽奖算法:{}",algorithmType==1 ? "总体概率算法" : "单体概率算法");

        // 4. 执行初始化概率hash数组
        IDrawAlgorithm drawAlgorithm = algorithmConfig.algorithmMap.get(algorithmType);
        try {
            drawAlgorithm.initRateHash(strategyId,algorithmType, fullAwardRateList);
        } catch (Exception e) {
            log.error("概率hash数组初始化失败");
        }

        // 5. 执行抽奖算法
        List<String> excludeAwardIdList = excludeAwardRateList.stream().map(AwardRateVO::getAwardId).collect(Collectors.toList());
        String awardId = drawAlgorithm.randomDraw(strategyId, excludeAwardIdList);
        if (!awardId.equals("感谢参与")) {
            // 6. 最后查询出对应的奖品，出发发奖流程
            Award award = awardMapper.queryAwardByAwardId(awardId);
            log.info("总体概率算法得到抽奖结果,strategyId:{}, award:{}",strategyId, JSONUtil.toJsonStr(award));
        } else {
            log.info("谢谢参与，下次再来");
        }
    }

    @Test
    public void testEntiretyRateAlgorithm() {
        Long strategyId = 10001L;
        List<AwardRateVO> excludeAwardRateList = new ArrayList<>();
        List<StrategyDetail> noStockDetailList = strategyDetailMapper.queryNoStockAward(strategyId);
        // 1. 得到排除的奖品列表
        for (StrategyDetail strategyDetail : noStockDetailList) {
            AwardRateVO rateVO = AwardRateVO
                    .builder()
                    .awardId(strategyDetail.getAwardId())
                    .awardRate(strategyDetail.getAwardRate())
                    .build();
            excludeAwardRateList.add(rateVO);
        }

        // 2. 查出strategyId对应的奖品列表
        List<StrategyDetail> awardDetailList = strategyDetailMapper.queryStrategyListById(strategyId);
        List<AwardRateVO> fullAwardRateList = new ArrayList<>();
        for (StrategyDetail strategyDetail : awardDetailList) {
            AwardRateVO rateVO = AwardRateVO
                    .builder()
                    .awardId(strategyDetail.getAwardId())
                    .awardRate(strategyDetail.getAwardRate())
                    .build();
            fullAwardRateList.add(rateVO);
        }

        // 3. 根据strategyId查出该策略属于那个抽奖算法
        Strategy strategy = strategyMapper.queryStrategyById(strategyId);
        Integer algorithmType = strategy.getGrantType();

        // 4. 执行初始化概率hash数组
        IDrawAlgorithm drawAlgorithm = algorithmConfig.algorithmMap.get(algorithmType);
        try {
            drawAlgorithm.initRateHash(strategyId,algorithmType, fullAwardRateList);
        } catch (Exception e) {
            log.error("概率hash数组初始化失败");
        }

        // 5. 执行抽奖算法
        List<String> excludeAwardIdList = excludeAwardRateList.stream().map(AwardRateVO::getAwardId).collect(Collectors.toList());
        String awardId = drawAlgorithm.randomDraw(strategyId, excludeAwardIdList);

        if (!awardId.equals("感谢参与")) {
            // 6. 最后查询出对应的奖品，出发发奖流程
            Award award = awardMapper.queryAwardByAwardId(awardId);
            log.info("总体概率算法得到抽奖结果,strategyId:{}, award:{}",strategyId, JSONUtil.toJsonStr(award));
        } else {
            log.info("谢谢参与，下次再来");
        }
    }

}

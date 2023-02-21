package com.frankzhou.domain.strategy.service.algorithm;

import com.frankzhou.domain.strategy.model.vo.AwardRateVO;

import java.util.List;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description
 * @date 2023-02-02
 */
public interface IDrawAlgorithm {

    /**
     * 初始化概率hash数组
     *
     * @author this.FrankZhou
     * @param strategyId 策略Id
     * @param strategyMode 抽奖策略模式
     * @param awardRateVOList 抽奖概率映射列表
     * @return
     */
    void initRateHash(Long strategyId, Integer strategyMode, List<AwardRateVO> awardRateVOList) throws InterruptedException;

    /**
     * 判断该strategyId对应的概率数组是否已经初始化
     *
     * @author this.FrankZhou
     * @param strategyId 策略Id
     * @return true->已经初始化/false->没有初始化
     */
    boolean isExist(Long strategyId);

    /**
     * 生成一个随机数，进行抽奖
     *
     * @author this.FrankZhou
     * @param strategyId 策略号
     * @param excludeAwardIdList 排除掉的奖品(库存原因或者风控原因)
     * @return 奖品编号
     */
    String randomDraw(Long strategyId, List<String> excludeAwardIdList);
}

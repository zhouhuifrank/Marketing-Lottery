package com.frankzhou.lottery.mapper;

import cn.hutool.json.JSONUtil;
import com.frankzhou.infrastructure.entity.StrategyDetail;
import com.frankzhou.infrastructure.mapper.StrategyDetailMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description
 * @date 2023-02-09
 */
@SpringBootTest
public class StrategyDetailMapperTest {

    @Resource
    private StrategyDetailMapper strategyDetailMapper;

    @Test
    public void testQueryStrategyListById() {
        Long strategyId = 10001L;
        List<StrategyDetail> strategyDetailList = strategyDetailMapper.queryStrategyListById(strategyId);
        strategyDetailList.stream().map(JSONUtil::toJsonStr).forEach(System.out::println);
    }

    @Test
    public void testQueryStrategyListByCond() {
        Long strategyId = 10001L;
        String awardId = "3";
        StrategyDetail strategyDetail = strategyDetailMapper.queryStrategyDetailByCond(strategyId, awardId);
        System.out.println(strategyDetail);
    }

    @Test
    public void testBatchInsert() {
        StrategyDetail strategyDetail1 = StrategyDetail
                .builder()
                .strategyId(10002L)
                .awardId("6")
                .awardName("小米M13")
                .awardCount(1000)
                .awardSurplusCount(900)
                .awardRate(new BigDecimal(0.01)).build();
        StrategyDetail strategyDetail2 = StrategyDetail
                .builder()
                .strategyId(10002L)
                .awardId("7")
                .awardName("小米M13 Pro")
                .awardCount(1000)
                .awardSurplusCount(700)
                .awardRate(new BigDecimal(0.005)).build();
        StrategyDetail strategyDetail3 = StrategyDetail
                .builder()
                .strategyId(10002L)
                .awardId("8")
                .awardName("小米耳机Buds4")
                .awardCount(2000)
                .awardSurplusCount(1500)
                .awardRate(new BigDecimal(0.02)).build();
        List<StrategyDetail> strategyDetailList = Arrays.asList(strategyDetail1,strategyDetail2,strategyDetail3);
        Integer count = strategyDetailMapper.batchInsert(strategyDetailList);
        System.out.println(count);
    }
}

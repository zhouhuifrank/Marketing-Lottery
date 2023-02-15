package com.frankzhou.lottery.mapper;

import com.frankzhou.infrastructure.entity.Strategy;
import com.frankzhou.infrastructure.mapper.StrategyMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description
 * @date 2023-02-09
 */
@SpringBootTest
public class StrategyMapperTest {

    @Resource
    private StrategyMapper strategyMapper;

    @Test
    public void testQueryStrategyById() {
        Long strategyId = 10001L;
        Strategy strategy = strategyMapper.queryStrategyById(strategyId);
        System.out.println(strategy);
    }

    @Test
    public void testInsertStrategy() {
        Strategy strategy = Strategy
                .builder()
                .strategyId(10002L)
                .strategyDesc("PDD策略")
                .strategyMode(2)
                .grantType(2)
                .grantDate(LocalDateTime.of(2023,4,1,12,0))
                .extInfo("测试代码使用").build();

        Integer count = strategyMapper.insertStrategy(strategy);
        System.out.println(count);
    }
}

package com.frankzhou.domain.award.service.goods;

import com.frankzhou.domain.award.repository.IAwardRepository;
import com.frankzhou.domain.award.repository.IOrderRepository;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 奖品发访抽象基类
 * @date 2023-02-02
 */
@Slf4j
public abstract class AbstractDistributionBase {

    @Resource
    protected IAwardRepository awardRepository;

    @Resource
    protected IOrderRepository orderRepository;

    protected void updateUserAwardState(String uId,Long orderId,String awardId,String awardState,String awardStateInfo) {
        log.info("TODO 后续实现分库分表将用户的参与抽奖记录更新到不同的库表中:{}",uId);
    }
}

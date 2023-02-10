package com.frankzhou.lottery.domain;

import com.frankzhou.common.constants.AwardType;
import com.frankzhou.domain.award.model.req.GoodsReq;
import com.frankzhou.domain.award.service.factory.AwardDistributionFactory;
import com.frankzhou.domain.award.service.goods.IDistributionGoods;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description
 * @date 2023-02-09
 */
@SpringBootTest
public class AwardDomainTest {

    @Resource
    private AwardDistributionFactory distributionFactory;

    @Test
    public void testGoodDistribution() {
        GoodsReq goodsReq = GoodsReq
                .builder()
                .uId("10001")
                .awardId("1")
                .awardContent("Mac苹果电脑")
                .awardName("IMac")
                .build();

        IDistributionGoods distributionService = distributionFactory.getDistributionService(AwardType.PHYSICAL_GOODS.getType());
        distributionService.doDistribution(goodsReq);
    }
}

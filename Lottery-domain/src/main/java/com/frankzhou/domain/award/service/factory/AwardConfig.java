package com.frankzhou.domain.award.service.factory;

import com.frankzhou.common.constants.AwardType;
import com.frankzhou.domain.award.service.goods.IDistributionGoods;
import com.frankzhou.domain.award.service.goods.impl.CouponGood;
import com.frankzhou.domain.award.service.goods.impl.DescriptionGood;
import com.frankzhou.domain.award.service.goods.impl.PhysicalGood;
import com.frankzhou.domain.award.service.goods.impl.RedeemCodeGood;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 奖品配置信息
 * @date 2023-02-02
 */
public class AwardConfig {

    protected static Map<Integer, IDistributionGoods> awardMap = new ConcurrentHashMap<>();

    @Resource
    private DescriptionGood descriptionGood;

    @Resource
    private CouponGood couponGood;

    @Resource
    private PhysicalGood physicalGood;

    @Resource
    private RedeemCodeGood redeemCodeGood;

    @PostConstruct
    public void init() {
        awardMap.put(AwardType.COUPON_GOODS.getType(), couponGood);
        awardMap.put(AwardType.DESC_GOODS.getType(), descriptionGood);
        awardMap.put(AwardType.PHYSICAL_GOODS.getType(), physicalGood);
        awardMap.put(AwardType.REDEEM_CODE_GOODS.getType(), redeemCodeGood);
    }
}

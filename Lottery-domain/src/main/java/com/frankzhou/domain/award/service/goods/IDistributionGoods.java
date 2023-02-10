package com.frankzhou.domain.award.service.goods;

import com.frankzhou.domain.award.model.req.GoodsReq;
import com.frankzhou.domain.award.model.res.DistributionRes;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 发货接口 将发放奖励抽象为发货扣减库存的流程
 * @date 2023-02-02
 */
public interface IDistributionGoods {

    /**
     * 发送奖励: 优惠卷、描述形象、实物奖励、兑换码
     *
     * @author this.FrankZhou
     * @param goodsReq 奖品信息请求类
     * @return 奖品信返回类
     */
    DistributionRes doDistribution(GoodsReq goodsReq);
}

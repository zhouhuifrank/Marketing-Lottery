package com.frankzhou.domain.award.service.goods.impl;

import com.frankzhou.common.constants.ResponseConstants;
import com.frankzhou.domain.award.model.req.GoodsReq;
import com.frankzhou.domain.award.model.res.DistributionRes;
import com.frankzhou.domain.award.service.goods.AbstractDistributionBase;
import com.frankzhou.domain.award.service.goods.IDistributionGoods;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description
 * @date 2023-02-02
 */
@Slf4j
@Component
public class PhysicalGood extends AbstractDistributionBase implements IDistributionGoods {
    @Override
    public DistributionRes doDistribution(GoodsReq goodsReq) {

        log.info("模拟调用实物发货服务(GoodMircoService)给用户:{} 发货信息:{}",goodsReq.getUId(),goodsReq.getAwardContent());

        super.updateUserAwardState(goodsReq.getUId(), goodsReq.getOrderId(), goodsReq.getAwardId(), ResponseConstants.SUCCESS.getCode(), ResponseConstants.SUCCESS.getInfo());

        DistributionRes res = new DistributionRes(goodsReq.getUId(),ResponseConstants.SUCCESS.getCode(),ResponseConstants.SUCCESS.getInfo());
        return res;
    }
}

package com.frankzhou.domain.award.service.factory;

import com.frankzhou.domain.award.service.goods.IDistributionGoods;
import org.springframework.stereotype.Service;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 奖品发放工厂 提供奖品配送服务
 * @date 2023-02-02
 */
@Service
public class AwardDistributionFactory extends AwardConfig {

    public IDistributionGoods getDistributionService(Integer awardType) {
        return awardMap.get(awardType);
    }
}

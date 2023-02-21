package com.frankzhou.domain.rule.service.logic.impl;

import com.frankzhou.domain.rule.model.req.DecisionFactorReq;
import com.frankzhou.domain.rule.service.logic.BaseLogicFilter;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 基于用户消费行为的过滤规则
 * @date 2023-02-21
 */
public class UserConsumeFilter extends BaseLogicFilter {

    @Override
    public String getFactorValue(DecisionFactorReq req) {
        return req.getValueMap().get("userConsume").toString();
    }
}

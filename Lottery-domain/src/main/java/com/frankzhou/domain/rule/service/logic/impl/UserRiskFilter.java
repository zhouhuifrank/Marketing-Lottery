package com.frankzhou.domain.rule.service.logic.impl;

import com.frankzhou.domain.rule.model.req.DecisionFactorReq;
import com.frankzhou.domain.rule.service.logic.BaseLogicFilter;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 基于用户风险的过滤规则
 * @date 2023-02-21
 */
public class UserRiskFilter extends BaseLogicFilter {

    @Override
    public String getFactorValue(DecisionFactorReq req) {
        return req.getValueMap().get("userRisk").toString();
    }
}

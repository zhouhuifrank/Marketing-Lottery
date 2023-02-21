package com.frankzhou.domain.rule.service.logic.impl;

import com.frankzhou.domain.rule.model.req.DecisionFactorReq;
import com.frankzhou.domain.rule.service.logic.BaseLogicFilter;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 用户年龄过滤规则
 * @date 2023-02-21
 */
public class UserAgeFilter extends BaseLogicFilter {

    @Override
    public String getFactorValue(DecisionFactorReq req) {
        return req.getValueMap().get("userAge").toString();
    }
}

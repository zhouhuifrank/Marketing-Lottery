package com.frankzhou.domain.rule.service.logic;

import com.frankzhou.common.constants.NodeLimitType;
import com.frankzhou.common.constants.NodeLimitTypeConstants;
import com.frankzhou.domain.rule.model.req.DecisionFactorReq;
import com.frankzhou.domain.rule.model.vo.RuleNodeLineVO;

import java.util.List;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 基础逻辑过滤器
 * @date 2023-02-21
 */
public abstract class BaseLogicFilter implements ILogicFilter {

    public static final Long NODE_NULL = 0L;

    @Override
    public Long filter(String factorValue, List<RuleNodeLineVO> ruleNodeLineVOList) {
        for (RuleNodeLineVO nodeLine : ruleNodeLineVOList) {
            // 匹配规则
            if (decisionLogic(factorValue,nodeLine)) {
                return nodeLine.getNodeIdTo();
            }
        }

        return NODE_NULL;
    }

    @Override
    public abstract String getFactorValue(DecisionFactorReq req);

    private boolean decisionLogic(String factorValue,RuleNodeLineVO ruleNodeLine) {
        Integer ruleType = ruleNodeLine.getRuleLimitType();
        String ruleValue = ruleNodeLine.getRuleLimitValue();
        if (ruleType.equals(NodeLimitType.EQUAL.getCode())) {
            return factorValue.equals(ruleNodeLine.getRuleLimitValue());
        } else if (ruleType.equals(NodeLimitType.GT.getCode())) {
            return Double.parseDouble(factorValue) > Double.parseDouble(ruleValue);
        } else if (ruleType.equals(NodeLimitType.LT.getCode())) {
            return Double.parseDouble(factorValue) < Double.parseDouble(ruleValue);
        } else if (ruleType.equals(NodeLimitType.GE.getCode())) {
            return Double.parseDouble(factorValue) >= Double.parseDouble(ruleValue);
        } else if (ruleType.equals(NodeLimitType.LE.getCode())) {
            return Double.parseDouble(factorValue) <= Double.parseDouble(ruleValue);
        }

        return false;
    }
}

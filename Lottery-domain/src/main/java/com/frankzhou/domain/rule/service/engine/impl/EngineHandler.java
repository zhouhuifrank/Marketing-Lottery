package com.frankzhou.domain.rule.service.engine.impl;

import com.frankzhou.domain.rule.model.aggregates.TreeRuleRich;
import com.frankzhou.domain.rule.model.req.DecisionFactorReq;
import com.frankzhou.domain.rule.model.res.EngineResult;
import com.frankzhou.domain.rule.model.vo.RuleNodeVO;
import com.frankzhou.domain.rule.service.engine.AbstractEngineBase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 引擎执行器
 * @date 2023-02-21
 */
@Slf4j
@Service("engineHandler")
public class EngineHandler extends AbstractEngineBase {

    @Override
    public EngineResult processDecision(DecisionFactorReq factorReq) {
        if (Objects.isNull(factorReq.getTreeId())) {
            throw new RuntimeException("Rule Engine error: Decision TreeId is null");
        }

        TreeRuleRich ruleRich = ruleRepository.queryTreeRuleRich(factorReq.getTreeId());
        if (Objects.isNull(ruleRich)) {
            throw new RuntimeException("The Rule is null treeId:" + factorReq.getTreeId());
        }

        RuleNodeVO ruleNode = super.decisionMaker(factorReq, ruleRich);

        EngineResult result = EngineResult
                .builder()
                .isSuccess(Objects.isNull(ruleNode) ? false : true)
                .nodeId(ruleNode.getTreeNodeId())
                .nodeValue(ruleNode.getNodeValue())
                .treeId(ruleNode.getTreeId())
                .userId(factorReq.getUserId())
                .build();

        return result;
    }
}

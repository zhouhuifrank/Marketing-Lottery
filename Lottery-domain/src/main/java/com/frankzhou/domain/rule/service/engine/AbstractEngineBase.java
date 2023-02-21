package com.frankzhou.domain.rule.service.engine;

import com.frankzhou.common.constants.NodeType;
import com.frankzhou.domain.rule.model.aggregates.TreeRuleRich;
import com.frankzhou.domain.rule.model.req.DecisionFactorReq;
import com.frankzhou.domain.rule.model.res.EngineResult;
import com.frankzhou.domain.rule.model.vo.RuleNodeLineVO;
import com.frankzhou.domain.rule.model.vo.RuleNodeVO;
import com.frankzhou.domain.rule.model.vo.RuleRootVO;
import com.frankzhou.domain.rule.repository.IRuleRepository;
import com.frankzhou.domain.rule.service.logic.ILogicFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 引擎执行器基础方法定义
 * @date 2023-02-21
 */
@Slf4j
public abstract class AbstractEngineBase extends EngineConfig implements IEngine {

    @Resource
    protected IRuleRepository ruleRepository;

    @Override
    public abstract EngineResult processDecision(DecisionFactorReq factorReq);

    protected RuleNodeVO decisionMaker(DecisionFactorReq factorReq, TreeRuleRich treeRuleRich) {
        // 遍历树节点
        RuleRootVO ruleRoot = treeRuleRich.getRuleRoot();
        Map<Long, RuleNodeVO> ruleNodeMap = treeRuleRich.getRuleNodeMap();

        // 通过根节点的Id拿到根节点
        Long rootId = ruleRoot.getTreeRootNodeId();
        RuleNodeVO ruleNode = ruleNodeMap.get(rootId);
        // 找到叶子节点就返回
        while (ruleNode.getNodeType().equals(NodeType.NOT_LEAF.getCode())) {
            String ruleKey = ruleNode.getRuleKey();
            ILogicFilter logicFilter = logicFilterMap.get(ruleKey);
            String factorValue = logicFilter.getFactorValue(factorReq);
            List<RuleNodeLineVO> ruleNodeLineVOList = ruleNode.getRuleNodeLineVOList();
            Long filterNode = logicFilter.filter(factorValue, ruleNodeLineVOList);
            // 遍历下一层决策树
            ruleNode = ruleNodeMap.get(filterNode);
            log.info("决策引擎结果 nodeId:{},nodeType:{},nodeValue:{},ruleKey:{}",ruleNode.getTreeNodeId(),
                    ruleNode.getNodeType(),ruleNode.getNodeValue(),ruleNode.getRuleKey());
        }

        return ruleNode;
    }
}

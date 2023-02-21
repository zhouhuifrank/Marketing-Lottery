package com.frankzhou.infrastructure.repository;

import cn.hutool.core.lang.tree.Tree;
import com.frankzhou.common.constants.NodeType;
import com.frankzhou.domain.rule.model.aggregates.TreeRuleRich;
import com.frankzhou.domain.rule.model.vo.RuleNodeLineVO;
import com.frankzhou.domain.rule.model.vo.RuleNodeVO;
import com.frankzhou.domain.rule.model.vo.RuleRootVO;
import com.frankzhou.domain.rule.repository.IRuleRepository;
import com.frankzhou.infrastructure.entity.RuleTree;
import com.frankzhou.infrastructure.entity.RuleTreeNode;
import com.frankzhou.infrastructure.entity.RuleTreeNodeLine;
import com.frankzhou.infrastructure.mapper.RuleTreeMapper;
import com.frankzhou.infrastructure.mapper.RuleTreeNodeLineMapper;
import com.frankzhou.infrastructure.mapper.RuleTreeNodeMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 规则仓储实现类
 * @date 2023-02-02
 */
@Repository
public class RuleRepository implements IRuleRepository {

    @Resource
    private RuleTreeMapper ruleTreeMapper;

    @Resource
    private RuleTreeNodeMapper ruleTreeNodeMapper;

    @Resource
    private RuleTreeNodeLineMapper ruleTreeNodeLineMapper;

    @Override
    public TreeRuleRich queryTreeRuleRich(Long treeId) {
        if (Objects.isNull(treeId)) {
            return null;
        }

        // 获取根节点
        RuleRootVO ruleRoot = new RuleRootVO();
        RuleTree ruleTree = ruleTreeMapper.queryRuleTreeByTreeId(treeId);
        ruleRoot.setTreeId(treeId);
        ruleRoot.setTreeRootNodeId(ruleTree.getTreeRootNodeId());
        ruleRoot.setTreeName(ruleTree.getTreeName());

        // 获取子节点
        Map<Long, RuleNodeVO> ruleTreeNodeMap = new HashMap<>();
        List<RuleTreeNode> nodeList = ruleTreeNodeMapper.queryTreeNodeList(treeId);
        for (RuleTreeNode node : nodeList) {
            // 构造每一个非叶节点的子节点
            List<RuleNodeLineVO> nodeLineVOList = new ArrayList<>();
            if (NodeType.NOT_LEAF.getCode().equals(node.getNodeType())) {
                // 查出非叶节点下的儿子节点
                Long nodeFrom = node.getId();
                List<RuleTreeNodeLine> ruleTreeNodeLineList = ruleTreeNodeLineMapper.queryTreeNodeLineList(treeId, nodeFrom);

                for (RuleTreeNodeLine nodeLine : ruleTreeNodeLineList) {
                    RuleNodeLineVO lineVO = new RuleNodeLineVO();
                    lineVO.setNodeIdFrom(nodeLine.getNodeIdFrom());
                    lineVO.setNodeIdTo(nodeLine.getNodeIdTo());
                    lineVO.setRuleLimitType(nodeLine.getRuleLimitType());
                    lineVO.setRuleLimitValue(nodeLine.getRuleLimitValue());
                    nodeLineVOList.add(lineVO);
                }
            }

            RuleNodeVO ruleNodeVO = new RuleNodeVO();
            ruleNodeVO.setTreeId(node.getId());
            ruleNodeVO.setTreeNodeId(treeId);
            ruleNodeVO.setNodeValue(node.getNodeValue());
            ruleNodeVO.setNodeType(node.getNodeType());
            ruleNodeVO.setRuleKey(node.getRuleKey());
            ruleNodeVO.setRuleDesc(node.getRuleDesc());
            ruleNodeVO.setRuleNodeLineVOList(nodeLineVOList);
            // id -> ruleNodeVo 通过id得到对应节点
            ruleTreeNodeMap.put(node.getId(),ruleNodeVO);
        }

        TreeRuleRich ruleRich = new TreeRuleRich();
        ruleRich.setRuleRoot(ruleRoot);
        ruleRich.setRuleNodeMap(ruleTreeNodeMap);

        return ruleRich;
    }
}

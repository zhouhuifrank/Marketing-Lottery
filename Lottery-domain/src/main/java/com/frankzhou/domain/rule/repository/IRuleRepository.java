package com.frankzhou.domain.rule.repository;

import com.frankzhou.domain.rule.model.aggregates.TreeRuleRich;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 规则树仓储服务
 * @date 2023-02-21
 */
public interface IRuleRepository {

    /**
     * 根据规则数的编号组装整个规则树
     *
     * @author this.FrankZhou
     * @param treeId 规则树编号
     * @return 规则树聚合对象
     */
    TreeRuleRich queryTreeRuleRich(Long treeId);
}

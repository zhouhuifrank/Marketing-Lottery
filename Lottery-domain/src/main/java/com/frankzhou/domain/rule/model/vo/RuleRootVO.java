package com.frankzhou.domain.rule.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 规则树根节点
 * @date 2023-02-21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RuleRootVO {

    /**
     * 规则树Id
     */
    private Long treeId;

    /**
     * 规则树根节点Id
     */
    private Long treeRootNodeId;

    /*
     * 规则树名称
     */
    private String treeName;
}

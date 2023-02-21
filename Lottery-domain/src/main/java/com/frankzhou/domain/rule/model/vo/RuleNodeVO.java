package com.frankzhou.domain.rule.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 规则树节点类
 * @date 2023-02-21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RuleNodeVO {

    /**
     * 树节点Id
     */
    private Long treeNodeId;

    /**
     * 规则树Id
     */
    private Long treeId;

    /**
     * 规则树类型
     */
    private Integer nodeType;

    /**
     * 树节点值
     */
    private String nodeValue;

    /**
     * 树节点关键字
     */
    private String ruleKey;

    /**
     * 节点规则描述
     */
    private String ruleDesc;

    private List<RuleNodeLineVO> ruleNodeLineVOList;
}

package com.frankzhou.domain.rule.model.aggregates;

import com.frankzhou.domain.rule.model.vo.RuleNodeVO;
import com.frankzhou.domain.rule.model.vo.RuleRootVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 规则树节点组装
 * @date 2023-02-21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TreeRuleRich {

    private RuleRootVO ruleRoot;

    private Map<Long, RuleNodeVO> ruleNodeMap;
}

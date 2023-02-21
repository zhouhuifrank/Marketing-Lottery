package com.frankzhou.domain.rule.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 规则树关联关系
 * @date 2023-02-21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RuleNodeLineVO {

    /**
     * 父节点信息
     */
    private Long nodeIdFrom;

    /**
     * 子节点信息
     */
    private Long nodeIdTo;

    /**
     * 规则约束类型 = > < >= <= 枚举值
     */
    private Integer ruleLimitType;

    /**
     * 规则约束值
     */
    private String ruleLimitValue;
}

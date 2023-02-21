package com.frankzhou.infrastructure.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 规则决策树节点信息
 * @date 2023-02-02
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("rule_tree_node")
public class RuleTreeNode {

    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    @TableField(value = "tree_id")
    private Integer treeId;

    @TableField(value = "node_type")
    private Integer nodeType;

    @TableField(value = "node_value")
    private String nodeValue;

    @TableField(value = "rule_key")
    private String ruleKey;

    @TableField(value = "rule_desc")
    private String ruleDesc;
}

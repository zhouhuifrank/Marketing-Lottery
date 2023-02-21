package com.frankzhou.infrastructure.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 规则决策树连线信息 用于找到某个节点的子树信息 以及保存具体规则信息
 * @date 2023-02-02
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("rule_tree_node_line")
public class RuleTreeNodeLine {

    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    @TableField(value = "tree_id")
    private Long treeId;

    @TableField(value = "node_id_from")
    private Long nodeIdFrom;

    @TableField(value = "node_id_to")
    private Long nodeIdTo;

    @TableField(value = "rule_limit_type")
    private Integer ruleLimitType;

    @TableField(value = "rule_limit_value")
    private String ruleLimitValue;
}

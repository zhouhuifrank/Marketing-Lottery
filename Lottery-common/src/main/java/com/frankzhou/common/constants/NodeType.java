package com.frankzhou.common.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 决策树节点类型
 * @date 2023-02-19
 */
@Getter
@AllArgsConstructor
public enum NodeType {

    ROOT(0,"根节点"),
    NOT_LEAF(1,"非叶节点"),
    LEAF(2,"叶子节点");

    private Integer code;

    private String info;
}

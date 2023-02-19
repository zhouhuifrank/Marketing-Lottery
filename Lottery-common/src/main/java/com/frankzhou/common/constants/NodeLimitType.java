package com.frankzhou.common.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 决策规则类型
 * @date 2023-02-19
 */
@Getter
@AllArgsConstructor
public enum NodeLimitType {

    EQUAL(1,"相等"),
    GT(2,"大于"),
    LT(3,"小于"),
    GE(4,"大于等于"),
    LE(5,"小于等于"),
    ENUM(6,"枚举");

    private Integer code;

    private String info;
}

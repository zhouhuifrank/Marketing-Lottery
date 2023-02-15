package com.frankzhou.common.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 活动状态枚举值
 * @date 2023-02-13
 */
@Getter
@AllArgsConstructor
public enum ActivityState {

    EDIT(1,"编辑"),
    ARRAIGNMENT(2,"提审"),
    REVOKE(3,"撤审"),
    DOING(4,"活动中"),
    PASS(5,"通过"),
    REFUSE(6,"拒绝"),
    CLOSE(7,"关闭"),
    OPEN(8,"开启");

    private Integer code;

    private String info;
}

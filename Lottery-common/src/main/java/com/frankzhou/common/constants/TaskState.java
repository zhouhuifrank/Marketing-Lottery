package com.frankzhou.common.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 活动单使用状态
 * @date 2023-02-19
 */
@Getter
@AllArgsConstructor
public enum TaskState {

    NO_USED(0,"未使用"),
    USED(1,"已使用");

    private Integer code;

    private String info;
}

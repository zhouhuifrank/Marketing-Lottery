package com.frankzhou.common.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 抽奖状态枚举类
 * @date 2023-02-19
 */
@Getter
@AllArgsConstructor
public enum DrawState {

    FAIL(0,"未中奖"),
    SUCCESS(1,"已中奖"),
    COVER(2,"兜底奖");

    private Integer code;

    private String info;
}

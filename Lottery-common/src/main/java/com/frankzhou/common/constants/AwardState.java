package com.frankzhou.common.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 发奖状态
 * @date 2023-02-19
 */
@Getter
@AllArgsConstructor
public enum AwardState {

    WAIT(0,"等待发奖"),
    SUCCESS(1,"发奖成功"),
    FAILURE(2,"发奖失败");

    private Integer code;

    private String info;
}

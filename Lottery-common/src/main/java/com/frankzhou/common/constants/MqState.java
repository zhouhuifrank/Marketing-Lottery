package com.frankzhou.common.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 消息队列消息发送状态
 * @date 2023-02-19
 */
@Getter
@AllArgsConstructor
public enum MqState {

    INIT(0,"初始"),
    COMPLETE(1,"完成"),
    FAILURE(2,"失败");

    private Integer code;

    private String info;
}

package com.frankzhou.common.exception;

/**
* @Author: this.FrankZhou
* @Description: 自定义异常
* @DateTime: 2023/1/6 14:33
*/
public class BaseException extends RuntimeException {

    public BaseException(String message) {
        super(message);
    }
}

package com.frankzhou.common.constants;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
* @Author: this.FrankZhou
* @Description: 系统响应码定义
* @DateTime: 2023/1/6 11:19
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseCode {
    private String code;

    private String info;
}

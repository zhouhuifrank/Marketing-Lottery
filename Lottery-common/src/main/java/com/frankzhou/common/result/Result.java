package com.frankzhou.common.result;

import com.frankzhou.common.constants.ResponseCode;
import com.frankzhou.common.constants.ResponseConstants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
* @Author: FrankZhou
* @Description: 前端统一返回类
* @DateTime: 2023/1/5 20:10
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result implements Serializable {
    private static final long serialVersionUID = 13827382L;

    private String code;

    private String info;

    public static Result getResult(String code,String info) {
        Result res = new Result(code,info);
        return res;
    }

    public static Result getResult(ResponseCode responseCode) {
        Result res = new Result();
        res.setCode(responseCode.getCode());
        res.setInfo(responseCode.getInfo());
        return res;
    }

    public static Result getSuccessResult() {
        Result res = new Result(ResponseConstants.SUCCESS.getCode(),ResponseConstants.SUCCESS.getInfo());
        return res;
    }

    public static Result getErrorResult(ResponseCode responseCode) {
        return getResult(responseCode);
    }
}

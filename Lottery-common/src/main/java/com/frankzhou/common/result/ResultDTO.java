package com.frankzhou.common.result;

import com.frankzhou.lottery.common.constants.ResponseCode;
import com.frankzhou.lottery.common.constants.ResponseConstants;
import lombok.Data;

import java.io.Serializable;

/**
* @Author: this.FrankZhou
* @Description: 前端统一返回类 version2
* @DateTime: 2023/1/6 13:55
*/
@Data
public class ResultDTO<T> implements Serializable {

    private static final long serialVersionUID = 1231231L;

    private T data;

    private String code;

    private String info;

    public static <T> ResultDTO<T> getResult(T data,String code,String info) {
        ResultDTO<T> result = new ResultDTO<>();
        result.setData(data);
        result.setCode(code);
        result.setInfo(info);
        return result;
    }

    public static <T> ResultDTO<T> getResult(String code,String info) {
        return getResult(null, code, info);
    }

    public static <T> ResultDTO<T> getResult(ResponseCode responseCode) {
        return getResult(responseCode.getCode(), responseCode.getInfo());
    }

    public static <T> ResultDTO<T> getSuccessResult() {
        return getResult(ResponseConstants.SUCCESS);
    }

    public static <T> ResultDTO<T> getSuccessResult(T data) {
        return getResult(data, ResponseConstants.SUCCESS.getCode(), ResponseConstants.SUCCESS.getInfo());
    }

    public static  <T> ResultDTO<T> getErrorResult(ResponseCode responseCode) {
        return getResult(responseCode);
    }

}

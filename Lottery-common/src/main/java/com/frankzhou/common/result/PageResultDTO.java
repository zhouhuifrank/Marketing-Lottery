package com.frankzhou.common.result;

import com.frankzhou.lottery.common.constants.ResponseCode;
import com.frankzhou.lottery.common.constants.ResponseConstants;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
* @Author: this.FrankZhou
* @Description: 前端统一分页结果返回类
* @DateTime: 2023/1/6 13:43
*/
@Data
public class PageResultDTO<T extends List<?>> implements Serializable  {

    private static final long serialVersionUID = 2131321L;

    private T dataList;

    private Integer pageCount;

    private String code;

    private String info;

    public static <T> PageResultDTO<List<T>> getResult(List<T> dataList,Integer pageCount,String code,String info) {
        PageResultDTO<List<T>> result = new PageResultDTO<>();
        result.setDataList(dataList);
        result.setPageCount(pageCount);
        result.setCode(code);
        result.setInfo(info);
        return result;
    }

    public static <T> PageResultDTO<List<T>> getResult(String code,String info) {
        return getResult(null,null,code,info);
    }

    public static <T> PageResultDTO<List<T>> getResult(ResponseCode responseCode) {
        return getResult(responseCode.getCode(),responseCode.getInfo());
    }

    public static <T> PageResultDTO<List<T>> getSuccessResult() {
        return getResult(ResponseConstants.SUCCESS);
    }

    public static <T> PageResultDTO<List<T>> getSuccessResult(List<T> dataList,Integer pageCount) {
        return getResult(dataList,pageCount,ResponseConstants.SUCCESS.getCode(),ResponseConstants.SUCCESS.getInfo());
    }

    public static <T> PageResultDTO<List<T>> getErrorResult(ResponseCode responseCode) {
        return getResult(responseCode);
    }
}

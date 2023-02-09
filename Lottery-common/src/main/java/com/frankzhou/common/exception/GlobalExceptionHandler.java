package com.frankzhou.common.exception;

import com.frankzhou.common.constants.ResponseCode;
import com.frankzhou.common.constants.ResponseConstants;
import com.frankzhou.common.result.ResultDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
* @Author: this.FrankZhou
* @Description: 全局异常处理类
* @DateTime: 2023/1/6 14:35
*/
@Slf4j
@ControllerAdvice(annotations = {Controller.class, RestController.class})
@Component
public class GlobalExceptionHandler {

    /**
     * @description: 处理BaseException
     * @param: request请求参数 ex异常
     * @return: Boolean
    */
    @ResponseBody
    @ExceptionHandler(value = BaseException.class)
    public ResultDTO<Boolean> baseExceptionHandler(HttpServletRequest request, BaseException ex) {
        String methodName = request.getMethod();
        Map<String, String[]> parameterMap = request.getParameterMap();

        log.error("Exception Method:{} params:{} message:{}",methodName,parameterMap,ex);
        return ResultDTO.getErrorResult(ResponseConstants.SYSTEM_ERROR);
    }
}

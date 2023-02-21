package com.frankzhou.lottery.controller;

import com.frankzhou.common.constants.ResponseConstants;
import com.frankzhou.common.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 测试连接
 * @date 2023-02-14
 */
@Slf4j
@RestController
@RequestMapping("/test")
public class HeartCheckController {

    @GetMapping("/connection")
    public Result testConnection() {
        return new Result(ResponseConstants.SUCCESS.getCode(), ResponseConstants.SUCCESS.getInfo());
    }
}

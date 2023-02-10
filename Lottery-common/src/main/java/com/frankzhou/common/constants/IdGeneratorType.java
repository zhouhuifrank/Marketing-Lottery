package com.frankzhou.common.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description
 * @date 2023-02-10
 */
@Getter
@AllArgsConstructor
public enum IdGeneratorType {

    SNOW_FLAKE(1,"雪花算法"),
    REDIS_ID(2,"Redis自增"),
    TIME_CODE(3,"日期算法"),
    RANDOM_NUMBER(4,"随机算法");

    private final Integer idType;

    private final String idGeneratorName;
}

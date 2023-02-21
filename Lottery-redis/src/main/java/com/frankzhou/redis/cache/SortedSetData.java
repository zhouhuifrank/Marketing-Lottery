package com.frankzhou.redis.cache;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description ZSet存储
 * @date 2023-02-18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SortedSetData {

    private double score;

    private Object data;
}

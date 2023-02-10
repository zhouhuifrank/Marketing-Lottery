package com.frankzhou.domain.award.model.res;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 发货结果类
 * @date 2023-02-10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DistributionRes {

    private String uId;

    private String code;

    private String info;
}

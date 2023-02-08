package com.frankzhou.common.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
* @Author: this.FrankZhou
* @Description: 奖品类别枚举类
* @DateTime: 2023/1/13 0:08
*/
@Getter
@AllArgsConstructor
public enum AwardType {

    COUPON_GOODS(1,"优惠卷"),
    DESC_GOODS(2,"描述信息"),
    PHYSICAL_GOODS(3,"事物信息"),
    REDEEM_CODE_GOODS(4,"兑换码");

    private final Integer type;

    private final String desc;
}

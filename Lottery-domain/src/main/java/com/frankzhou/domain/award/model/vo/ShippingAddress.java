package com.frankzhou.domain.award.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.jmx.export.annotation.ManagedNotification;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 收获地址信息
 * @date 2023-02-10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShippingAddress {

    private String name;

    private String provinceId;

    private String provinceName;

    private String cityId;

    private String cityName;

    private String countyId;

    private String countyName;

    private String townId;

    private String townName;

    private String address;

    private String phone;

    private String email;

    private String remark;
}

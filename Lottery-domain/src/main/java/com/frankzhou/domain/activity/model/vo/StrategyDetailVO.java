package com.frankzhou.domain.activity.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description
 * @date 2023-02-11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StrategyDetailVO {

    private Long strategyId;

    private String awardId;

    private String awardName;

    private Integer awardCount;

    private Integer awardSurplusCount;

    private BigDecimal awardRate;
}

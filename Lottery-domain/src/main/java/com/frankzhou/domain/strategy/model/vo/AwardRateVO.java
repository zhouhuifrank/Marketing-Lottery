package com.frankzhou.domain.strategy.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 奖品id和中奖概率的映射
 * @date 2023-02-17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AwardRateVO {

    private String awardId;

    private BigDecimal awardRate;
}

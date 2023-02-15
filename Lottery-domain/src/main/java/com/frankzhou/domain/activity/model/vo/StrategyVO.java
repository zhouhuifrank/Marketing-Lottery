package com.frankzhou.domain.activity.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

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
public class StrategyVO {

    private Long strategyId;

    private String strategyDesc;

    private Integer strategyMode;

    private Integer grantType;

    private LocalDateTime grantDate;

    private String extInfo;

    private List<StrategyDetailVO> strategyDetailList;
}

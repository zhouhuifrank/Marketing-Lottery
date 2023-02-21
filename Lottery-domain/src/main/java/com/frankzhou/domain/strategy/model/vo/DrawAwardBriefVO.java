package com.frankzhou.domain.strategy.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 抽奖结果封装实体类
 * @date 2023-02-19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DrawAwardBriefVO {

    private String uId;

    private String awardId;

    private Integer awardType;

    private String awardName;

    private String awardContent;

    private Integer strategyMode;

    private Integer grantType;

    private LocalDateTime grantDate;
}

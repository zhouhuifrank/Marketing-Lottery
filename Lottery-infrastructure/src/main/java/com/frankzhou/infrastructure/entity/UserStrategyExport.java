package com.frankzhou.infrastructure.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 用户抽奖结果记录表 采用分库分表设计
 * @date 2023-02-02
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserStrategyExport extends BaseEntity {

    private Long id;

    private String uId;

    private Long activityId;

    private Long orderId;

    private Long strategyId;

    private Integer strategyMode;

    private Integer grantType;

    private LocalDateTime grantDate;

    private Integer grantState;

    private String awardId;

    private Integer awardType;

    private String awardName;

    private String awardContent;

    private String uuid;

    private Integer mqState;
}

package com.frankzhou.infrastructure.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 用户活动参与表 采用分库不分表设计
 * @date 2023-02-02
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserTakeActivity extends BaseEntity {

    private Long id;

    private String uId;

    private Long takeId;

    private Long activityId;

    private String activityName;

    private LocalDateTime takeDate;

    private Integer takeCount;

    private Integer strategyId;

    private Integer state;

    private String uuid;
}

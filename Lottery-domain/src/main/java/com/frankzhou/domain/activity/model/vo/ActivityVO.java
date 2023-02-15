package com.frankzhou.domain.activity.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

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
public class ActivityVO {

    private Long activityId;

    private String activityName;

    private String activityDesc;

    private LocalDateTime beginDateTime;

    private LocalDateTime endDateTime;

    private Integer stockCount;

    private Integer stockSurplusCount;

    private Integer takeCount;

    private Long strategyId;

    private Integer state;

    private String creator;
}

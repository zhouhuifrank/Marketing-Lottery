package com.frankzhou.infrastructure.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 用户活动参与数 采用分库不分表设计
 * @date 2023-02-02
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserTakeActivityCount extends BaseEntity {

    private Long id;

    private String uId;

    private Long activityId;

    private Integer totalCount;

    private Integer leftCount;
}

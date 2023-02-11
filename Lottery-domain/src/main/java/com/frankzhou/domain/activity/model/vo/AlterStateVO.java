package com.frankzhou.domain.activity.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class AlterStateVO {

    private Long activityId;

    private Integer beforeState;

    private Integer afterState;
}

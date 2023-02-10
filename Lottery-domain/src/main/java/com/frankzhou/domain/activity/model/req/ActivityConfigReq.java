package com.frankzhou.domain.activity.model.req;

import com.frankzhou.domain.activity.model.aggregates.ActivityConfigRich;
import lombok.AllArgsConstructor;
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
public class ActivityConfigReq {

    private Long activityId;

    private ActivityConfigRich activityConfigRich;
}

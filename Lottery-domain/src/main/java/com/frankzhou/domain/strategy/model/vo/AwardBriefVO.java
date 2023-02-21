package com.frankzhou.domain.strategy.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 奖品实体类
 * @date 2023-02-19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AwardBriefVO {

    private String awardId;

    private Integer awardType;

    private String awardName;

    private String awardContent;
}

package com.frankzhou.rpc.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 活动奖品实体类
 * @date 2023-02-17
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AwardDTO implements Serializable {
    private static final long serialVersionUID = 123187193L;

    private String awardId;

    private Integer awardType;

    private String awardName;

    private String awardContent;
}

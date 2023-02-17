package com.frankzhou.rpc.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 活动奖品请求参数
 * @date 2023-02-17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AwardReq implements Serializable {
    private static final long serialVersionUID = 138129312L;

    private String awardId;

    private Integer awardType;
}

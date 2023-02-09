package com.frankzhou.rpc.req;

import lombok.Data;

import java.io.Serializable;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description
 * @date 2023-02-02
 */
@Data
public class ActivityReq implements Serializable {
    private static final long serialVersionUID = 1238913L;

    private Long activityId;

    private String userId;
}

package com.frankzhou.domain.strategy.model.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 抽奖请求对象  用户id加策略号进行抽奖
 * @date 2023-02-19
 */
@Data
public class DrawReq {

    private String uId;

    private Long strategyId;

    private String uuid;

    public DrawReq() {

    }

    public DrawReq(String uId, Long strategyId) {
        this.uId = uId;
        this.strategyId = strategyId;
    }

    public DrawReq(String uId, Long strategyId, String uuid) {
        this.uId = uId;
        this.strategyId = strategyId;
        this.uuid = uuid;
    }
}

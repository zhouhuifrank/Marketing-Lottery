package com.frankzhou.domain.strategy.service.draw;

import com.frankzhou.domain.strategy.model.req.DrawReq;
import com.frankzhou.domain.strategy.model.res.DrawResult;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description
 * @date 2023-02-02
 */
public interface IDrawExecute {

    /**
     * 执行抽奖流程
     *
     * @author this.FrankZhou
     * @param req 抽奖请求参数：用户Id、策略Id
     * @return 抽奖包装结果
     */
    DrawResult doDrawAward(DrawReq req);
}

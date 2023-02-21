package com.frankzhou.domain.rule.service.engine;

import com.frankzhou.domain.rule.model.req.DecisionFactorReq;
import com.frankzhou.domain.rule.model.res.EngineResult;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 规则引擎执行器接口
 * @date 2023-02-21
 */
public interface IEngine {

    /**
     * 规则引擎决策过程
     *
     * @author this.FrankZhou
     * @param factorReq 决策请求参数
     * @return 规则引擎执行结果
     */
    EngineResult processDecision(DecisionFactorReq factorReq);
}

package com.frankzhou.domain.rule.service.logic;

import com.frankzhou.domain.rule.model.req.DecisionFactorReq;
import com.frankzhou.domain.rule.model.vo.RuleNodeLineVO;

import java.util.List;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 逻辑过滤器接口
 * @date 2023-02-21
 */
public interface ILogicFilter {

    /**
     * 过滤规则得到下一个节点
     *
     * @author this.FrankZhou
     * @param factorValue 决策因素值
     * @param ruleNodeLineVOList 子节点列表
     * @return 下一个节点编号
     */
    Long filter(String factorValue, List<RuleNodeLineVO> ruleNodeLineVOList);

    /**
     * 获得决策值
     *
     * @author this.FrankZhou
     * @param req 决策因素请求参数
     * @return 决策值
     */
    String getFactorValue(DecisionFactorReq req);
}

package com.frankzhou.domain.rule.model.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 决策因素请求类
 * @date 2023-02-21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DecisionFactorReq {

    private Long treeId;

    private String userId;

    private Map<String,Object> valueMap;
}

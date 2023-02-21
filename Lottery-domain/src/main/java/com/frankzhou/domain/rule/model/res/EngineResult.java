package com.frankzhou.domain.rule.model.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 规则引擎执行结果
 * @date 2023-02-21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EngineResult {

    private Boolean isSuccess;

    private Long treeId;

    private String userId;

    private Long nodeId;

    private String nodeValue;
}

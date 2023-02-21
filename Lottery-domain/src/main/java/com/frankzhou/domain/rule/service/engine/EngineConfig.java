package com.frankzhou.domain.rule.service.engine;

import com.frankzhou.domain.rule.service.logic.ILogicFilter;
import com.frankzhou.domain.rule.service.logic.impl.UserAgeFilter;
import com.frankzhou.domain.rule.service.logic.impl.UserConsumeFilter;
import com.frankzhou.domain.rule.service.logic.impl.UserGenderFilter;
import com.frankzhou.domain.rule.service.logic.impl.UserRiskFilter;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 规则类型配置类
 * @date 2023-02-21
 */
public class EngineConfig {

    protected Map<String, ILogicFilter> logicFilterMap = new ConcurrentHashMap<>();

    @Resource
    private UserAgeFilter userAgeFilter;

    @Resource
    private UserConsumeFilter userConsumeFilter;

    @Resource
    private UserGenderFilter userGenderFilter;

    @Resource
    private UserRiskFilter userRiskFilter;

    @PostConstruct
    public void init() {
        logicFilterMap.put("userAge",userAgeFilter);
        logicFilterMap.put("userConsume",userConsumeFilter);
        logicFilterMap.put("userGender",userGenderFilter);
        logicFilterMap.put("userRisk",userRiskFilter);
    }
}

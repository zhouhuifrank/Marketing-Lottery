package com.frankzhou.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.frankzhou.infrastructure.entity.RuleTree;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 规则引擎规则树
 * @date 2023-02-02
 */
@Mapper
public interface RuleTreeMapper extends BaseMapper<RuleTree> {

    RuleTree queryRuleTreeByTreeId(@Param("id") Long id);

    RuleTree queryRuleSummaryInfo(@Param("id") Long id);
}

package com.frankzhou.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.frankzhou.infrastructure.entity.Strategy;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 策略表
 * @date 2023-02-02
 */
@Mapper
public interface StrategyMapper extends BaseMapper<Strategy> {

}

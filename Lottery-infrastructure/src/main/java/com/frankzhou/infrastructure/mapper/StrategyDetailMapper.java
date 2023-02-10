package com.frankzhou.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.frankzhou.infrastructure.entity.StrategyDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 策略明细表
 * @date 2023-02-02
 */
@Mapper
public interface StrategyDetailMapper extends BaseMapper<StrategyDetail> {

    Integer batchInsert(@Param("list") List<StrategyDetail> strategyDetailList);

    Integer batchUpdate(@Param("list") List<StrategyDetail> strategyDetailList);

}

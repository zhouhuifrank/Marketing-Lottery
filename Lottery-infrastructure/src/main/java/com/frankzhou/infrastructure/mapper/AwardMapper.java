package com.frankzhou.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.frankzhou.infrastructure.entity.Award;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 奖品信息表
 * @date 2023-02-02
 */
@Mapper
public interface AwardMapper extends BaseMapper<Award> {

}

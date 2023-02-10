package com.frankzhou.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.frankzhou.infrastructure.entity.Activity;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 活动信息表
 * @date 2023-02-02
 */
@Mapper
public interface ActivityMapper extends BaseMapper<Activity> {
    Activity queryActivityById(@Param("activityId") Long activityId);
}

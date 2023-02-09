package com.frankzhou.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.frankzhou.infrastructure.entity.UserTakeActivity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 用户活动参与表
 * @date 2023-02-02
 */
@Mapper
public interface UserTakeActivityMapper extends BaseMapper<UserTakeActivity> {
}

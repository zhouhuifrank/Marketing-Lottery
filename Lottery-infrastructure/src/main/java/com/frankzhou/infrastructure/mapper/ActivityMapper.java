package com.frankzhou.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.frankzhou.domain.activity.model.vo.AlterStateVO;
import com.frankzhou.infrastructure.entity.Activity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 活动信息表
 * @date 2023-02-02
 */
@Mapper
public interface ActivityMapper extends BaseMapper<Activity> {

    Integer insertActivity(Activity activity);

    // TODO 更新暂时不测试
    Integer updateActivity(Activity activity);

    Integer alterActivityState(AlterStateVO alterStateVO);

    Activity queryActivityById(@Param("activityId") Long activityId);
}

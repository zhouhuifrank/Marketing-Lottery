package com.frankzhou.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.frankzhou.infrastructure.entity.Award;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 奖品信息表
 * @date 2023-02-02
 */
@Mapper
public interface AwardMapper extends BaseMapper<Award> {

    Integer batchInsert(@Param("list") List<Award> awardList);

    // TODO 批量更新暂时不测试
    Integer batchUpdate(@Param("list") List<Award> awardList);

    Award queryAwardByAwardId(@Param("awardId") String awardId);

    List<Award> queryAwardByAwardType(@Param("awardType") Integer awardType);
}

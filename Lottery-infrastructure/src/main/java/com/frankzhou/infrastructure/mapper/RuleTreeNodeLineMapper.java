package com.frankzhou.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.frankzhou.infrastructure.entity.RuleTreeNodeLine;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description
 * @date 2023-02-02
 */
@Mapper
public interface RuleTreeNodeLineMapper extends BaseMapper<RuleTreeNodeLine> {

    List<RuleTreeNodeLine> queryTreeNodeLineList(@Param("treeId") Long treeId,@Param("nodeIdFrom") Long nodeIdFrom);

    Integer queryTreeNodeLineCount(@Param("treeId") Long treeId);
}

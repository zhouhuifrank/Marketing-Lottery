package com.frankzhou.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.frankzhou.infrastructure.entity.RuleTreeNode;
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
public interface RuleTreeNodeMapper extends BaseMapper<RuleTreeNode> {

    List<RuleTreeNode> queryTreeNodeList(@Param("treeId") Long treeId);

    Integer queryTreeNodeCount(@Param("list") Long treeId);

    List<RuleTreeNode> queryTreeNodePoint(@Param("treeId") Long treeId);
}

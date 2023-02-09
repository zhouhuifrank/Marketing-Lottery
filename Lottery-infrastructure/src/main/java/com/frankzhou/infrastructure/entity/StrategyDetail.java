package com.frankzhou.infrastructure.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description
 * @date 2023-02-02
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName(value = "strategy_detail")
public class StrategyDetail extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 173812L;

    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    @TableField(value = "strategy_id")
    private Long strategyId;

    @TableField(value = "award_id")
    private String awardId;

    @TableField(value = "award_name")
    private String awardName;

    @TableField(value = "award_count")
    private Integer awardCount;

    @TableField(value = "award_surplus_count")
    private Integer awardSurplusCount;

    @TableField(value = "award_rate")
    private BigDecimal awardRate;
}

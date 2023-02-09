package com.frankzhou.infrastructure.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

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
@TableName(value = "activity")
public class Activity extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 72837113L;

    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    @TableField(value = "activity_id")
    private Long activityId;

    @TableField(value = "strategy_id")
    private Long strategyId;

    @TableField(value = "activity_name")
    private String activityName;

    @TableField(value = "activity_desc")
    private String activityDesc;

    @TableField(value = "begin_date_time")
    private LocalDateTime beginDateTime;

    @TableField(value = "end_date_time")
    private LocalDateTime endDateTime;

    @TableField(value = "stock_count")
    private Integer stockCount;

    @TableField(value = "stock_surplus_count")
    private Integer stockSurplusCount;

    @TableField(value = "take_count")
    private Integer takeCount;

    @TableField(value = "state")
    private Integer state;

    @TableField(value = "creator")
    private String creator;
}

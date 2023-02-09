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
@TableName(value = "strategy")
public class Strategy extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 27381371L;

    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    @TableField(value = "strategy_id")
    private Long strategyId;

    @TableField(value = "strategy_desc")
    private String strategyDesc;

    @TableField(value = "strategy_mode")
    private Integer strategyMode;

    @TableField(value = "grant_type")
    private Integer grantType;

    @TableField(value = "grant_date")
    private LocalDateTime grantDate;

    @TableField(value = "ext_info")
    private String extInfo;
}

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
@TableName(value = "award")
public class Award extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1237831L;

    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    @TableField(value = "award_id")
    private String awardId;

    @TableField(value = "award_type")
    private Integer awardType;

    @TableField(value = "award_name")
    private String awardName;

    @TableField(value = "award_content")
    private String awardContent;
}

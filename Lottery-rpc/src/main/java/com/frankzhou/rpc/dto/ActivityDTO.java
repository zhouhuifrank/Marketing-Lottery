package com.frankzhou.rpc.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 活动前端返回对象
 * @date 2023-02-02
 */
@Data
@Builder
public class ActivityDTO implements Serializable {
    private static final long serialVersionUID = 2183198L;

    private Long id;

    private String activityName;

    private String activityDesc;

    private LocalDateTime beginDateTime;

    private LocalDateTime endDateTime;

    private Integer stockCount;

    private Integer stockSurplusCount;

    private Integer takeCount;

}

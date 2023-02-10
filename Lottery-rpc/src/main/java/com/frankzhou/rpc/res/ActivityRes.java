package com.frankzhou.rpc.res;

import com.frankzhou.common.result.Result;
import com.frankzhou.rpc.dto.ActivityDTO;
import lombok.AllArgsConstructor;
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
public class ActivityRes implements Serializable {
    private static final long serialVersionUID = 1372321L;

    private Result result;

    private ActivityDTO activityDTO;
}

package com.frankzhou.rpc.res;

import com.frankzhou.common.result.Result;
import com.frankzhou.rpc.dto.AwardDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 活动奖品响应实体
 * @date 2023-02-17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AwardRes implements Serializable {
    private static final long serialVersionUID= 1389123L;

    private List<AwardDTO> awardList;

    private Result result;
}

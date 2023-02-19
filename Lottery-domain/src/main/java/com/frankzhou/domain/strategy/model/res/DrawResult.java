package com.frankzhou.domain.strategy.model.res;

import com.frankzhou.domain.strategy.model.vo.DrawAwardVO;
import lombok.Builder;
import lombok.Data;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 抽奖结果对象
 * @date 2023-02-19
 */
@Data
@Builder
public class DrawResult {

    private String uId;

    private Long strategyId;

    /**
     * 0/未中奖  1/中奖  2/兜底奖
     */
    private Integer drawState;

    private DrawAwardVO drawAwardVO;

    public DrawResult() {

    }

    public DrawResult(String uId,Long strategyId,Integer drawState) {
        this.uId = uId;
        this.strategyId = strategyId;
        this.drawState = drawState;
    }

    public DrawResult(String uId,Long strategyId,Integer drawState,DrawAwardVO drawAwardVO) {
        this.uId = uId;
        this.strategyId = strategyId;
        this.drawState = drawState;
        this.drawAwardVO = drawAwardVO;
    }
}

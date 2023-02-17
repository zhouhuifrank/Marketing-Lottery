package com.frankzhou.rpc;

import com.frankzhou.rpc.req.AwardReq;
import com.frankzhou.rpc.res.AwardRes;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 活动奖品PRC接口
 * @date 2023-02-17
 */
public interface IAwardService {

    /**
     * 根据奖品类型查询奖品
     *
     * @author this.FrankZhou
     * @param req 请求参数
     * @return 对于的奖品列表
     */
    AwardRes queryAwardByAwardType(AwardReq req);


}

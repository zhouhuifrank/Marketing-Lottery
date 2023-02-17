package com.frankzhou.lottery.interfaces;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.frankzhou.common.constants.ResponseConstants;
import com.frankzhou.common.result.Result;
import com.frankzhou.infrastructure.entity.Award;
import com.frankzhou.infrastructure.mapper.AwardMapper;
import com.frankzhou.rpc.IAwardService;
import com.frankzhou.rpc.dto.AwardDTO;
import com.frankzhou.rpc.req.AwardReq;
import com.frankzhou.rpc.res.AwardRes;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 活动奖品RPC调用接口实现类
 * @date 2023-02-17
 */
@Slf4j
@DubboService
public class AwardServiceImpl implements IAwardService {

    @Resource
    private AwardMapper awardMapper;

    @Override
    public AwardRes queryAwardByAwardType(AwardReq req) {
        if (StringUtils.isEmpty(req.getAwardType())) {
            return new AwardRes(null, new Result(ResponseConstants.ILLEGAL_PARAMS.getCode(),ResponseConstants.ILLEGAL_PARAMS.getInfo()));
        }

        log.info("正在查询奖品信息，请求参数:{}", JSONUtil.toJsonStr(req));
        Integer awardType = req.getAwardType();
        List<Award> awardList = awardMapper.queryAwardByAwardType(awardType);
        if (CollectionUtil.isEmpty(awardList)) {
            return new AwardRes(null, new Result(ResponseConstants.DB_QUERY_NO_DATA.getCode(),ResponseConstants.DB_QUERY_NO_DATA.getInfo()));
        }

        List<AwardDTO> awardDTOList = new ArrayList<>();
        for (Award award : awardList) {
            AwardDTO dto = new AwardDTO();
            BeanUtil.copyProperties(award,dto);
            awardDTOList.add(dto);
        }

        log.info("根据奖品类型查询到奖品列表:{}", JSON.toJSONString(awardDTOList));
        AwardRes response = new AwardRes();
        response.setAwardList(awardDTOList);
        response.setResult(new Result(ResponseConstants.SUCCESS.getCode(),ResponseConstants.SUCCESS.getInfo()));
        return response;
    }
}

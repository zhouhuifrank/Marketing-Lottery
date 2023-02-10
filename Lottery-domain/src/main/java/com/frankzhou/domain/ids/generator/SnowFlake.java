package com.frankzhou.domain.ids.generator;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.IdUtil;
import com.frankzhou.domain.ids.IIdGenerator;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description
 * @date 2023-02-02
 */
@Component(value = "SnowFlake")
public class SnowFlake implements IIdGenerator {

    private Snowflake snowFlake;

    @PostConstruct
    public void init() {
        // 0~31位，可以采用配置的方式使用
        long workerId;
        try {
            workerId = NetUtil.ipv4ToLong(NetUtil.getLocalhostStr());
        } catch (Exception e) {
            workerId = NetUtil.getLocalhostStr().hashCode();
        }

        workerId = workerId >> 16 & 31;

        long dataCenterId = 1L;
        snowFlake = IdUtil.getSnowflake(workerId,dataCenterId);
    }

    @Override
    public Long nextId() {
        return snowFlake.nextId();
    }
}

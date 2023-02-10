package com.frankzhou.domain.ids;

import com.frankzhou.common.constants.IdGeneratorType;
import com.frankzhou.domain.ids.generator.RandomNumber;
import com.frankzhou.domain.ids.generator.RedisId;
import com.frankzhou.domain.ids.generator.SnowFlake;
import com.frankzhou.domain.ids.generator.TimeCode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description Id生成器上下文对象
 * @date 2023-02-02
 */
@Configuration
public class IdContext {

    private SnowFlake snowFlake;

    private RedisId redisId;

    private TimeCode timeCode;

    private RandomNumber randomNumber;

    public IdContext(SnowFlake snowFlake,RedisId redisId,TimeCode timeCode,RandomNumber randomNumber) {
        this.snowFlake = snowFlake;
        this.redisId = redisId;
        this.timeCode = timeCode;
        this.randomNumber = randomNumber;
    }

    @Bean
    public Map<IdGeneratorType,IIdGenerator> getIdMap() {
        Map<IdGeneratorType,IIdGenerator> idGeneratorMap = new ConcurrentHashMap<>();
        idGeneratorMap.put(IdGeneratorType.SNOW_FLAKE, snowFlake);
        idGeneratorMap.put(IdGeneratorType.REDIS_ID, redisId);
        idGeneratorMap.put(IdGeneratorType.TIME_CODE, timeCode);
        idGeneratorMap.put(IdGeneratorType.RANDOM_NUMBER, randomNumber);
        return idGeneratorMap;
    }
}

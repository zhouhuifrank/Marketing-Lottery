package com.frankzhou.domain.strategy.service.algorithm;

import com.frankzhou.common.constants.AlgorithmType;
import com.frankzhou.domain.strategy.model.vo.AwardRateVO;
import com.frankzhou.redis.cache.RedisKeys;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.security.SecureRandom;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 抽奖策略基类
 * @date 2023-02-02
 */
@Slf4j
public abstract class AbstractAlgorithmBase implements IDrawAlgorithm {

    /**
     * 斐波拿起散列值
     */
    private final int HASH_INCREMENT = 0x61c88647;

    /**
     * hash数组的长度，必须为2的幂次，且能包含映射到所有概率值
     */
    private final int HASH_LENGTH = 128;

    /**
     * strategyId->概率hash数组
     * 通过此数组获取该策略对应的奖品概率hash数组
     */
    protected Map<Long,String[]> rateHashArrayMap = new ConcurrentHashMap<>();

    /**
     * strategyId->概率列表
     * 通过strategyId获取list，用于生成hash数组
     */
    protected Map<Long,List<AwardRateVO>> rateInfoMap = new ConcurrentHashMap<>();

    @Resource
    private RedissonClient redissonClient;

    @Override
    public void initRateHash(Long strategyId, Integer strategyMode, List<AwardRateVO> awardRateVOList) throws InterruptedException {
        // 存在于rateInfoMap说明已经初始化过了
        if (isExist(strategyId)) {
            return;
        }

        rateInfoMap.put(strategyId,awardRateVOList);
        if (strategyMode.equals(AlgorithmType.DEFAULT_RATE.getStrategyId())) {
            return;
        }
        log.info("抽奖概率hash数组开始初始化");
        // 初始化哈希数组值，需要加锁
        RLock lock = redissonClient.getLock(RedisKeys.INIT_HASH_KEY);
        // 等待10秒，锁一秒后就释放
        boolean isLock = lock.tryLock(10,1, TimeUnit.SECONDS);
        if (isLock) {
            try {
                String[] hashArray = rateHashArrayMap.computeIfAbsent(strategyId, key -> new String[HASH_LENGTH]);

                int prevPos = 0;
                for (AwardRateVO awardRateVO : awardRateVOList) {
                    BigDecimal awardRate = awardRateVO.getAwardRate();
                    int currPos = awardRate.multiply(new BigDecimal(100)).intValue();

                    // 循环给hash数组赋值
                    for (int i=prevPos;i<(prevPos+currPos);i++) {
                        hashArray[getHashIndex(i)] = awardRateVO.getAwardId();
                    }
                    prevPos += currPos;
                }
                log.info("抽奖概率hash数组初始化完成");
            } finally {
                lock.unlock();
            }
        }
    }

    @Override
    public boolean isExist(Long strategyId) {
        return rateInfoMap.containsKey(strategyId);
    }

    protected int getHashIndex(int number) {
        int hashCode = number * HASH_INCREMENT + HASH_INCREMENT;
        int hashIndex = hashCode & (HASH_LENGTH-1);
        return hashIndex;
    }

    protected int getRandomNumber(int bound) {
        SecureRandom secureRandom = new SecureRandom();
        int randomNum = secureRandom.nextInt(bound) + 1;
        return randomNum;
    }
}

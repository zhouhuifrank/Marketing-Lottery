package com.frankzhou.domain.ids.generator;

import cn.hutool.core.util.RandomUtil;
import com.frankzhou.domain.ids.IIdGenerator;
import org.springframework.stereotype.Component;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description
 * @date 2023-02-02
 */
@Component(value = "RandomNumber")
public class RandomNumber implements IIdGenerator {
    @Override
    public Long nextId() {
        return Long.valueOf(RandomUtil.randomNumbers(11));
    }
}

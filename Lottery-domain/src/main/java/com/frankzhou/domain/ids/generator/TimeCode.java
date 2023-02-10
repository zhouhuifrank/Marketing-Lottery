package com.frankzhou.domain.ids.generator;

import cn.hutool.core.util.RandomUtil;
import com.frankzhou.domain.ids.IIdGenerator;
import org.springframework.stereotype.Component;

import java.util.Calendar;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 日期编号生成 短码生成 用于活动配置编号
 * @date 2023-02-02
 */
@Component(value = "TimeCode")
public class TimeCode implements IIdGenerator {
    @Override
    public Long nextId() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int week = calendar.get(Calendar.WEEK_OF_YEAR);
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);

        StringBuilder idStr = new StringBuilder();
        idStr.append(year-2020);
        idStr.append(week);
        idStr.append(day);
        idStr.append(String.format("%02d",hour));
        idStr.append(RandomUtil.randomNumbers(4));
        String code = idStr.toString();

        return Long.parseLong(code);
    }
}

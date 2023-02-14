package com.frankzhou.lottery.mapper;

import cn.hutool.json.JSONUtil;
import com.frankzhou.infrastructure.entity.Award;
import com.frankzhou.infrastructure.mapper.AwardMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description
 * @date 2023-02-09
 */
@SpringBootTest
public class AwardMapperTest {

    @Resource
    private AwardMapper awardMapper;

    @Test
    public void testQueryAwardByAwardId() {
        String awardId = "1";
        Award award = awardMapper.queryAwardByAwardId(awardId);
        System.out.println(award);
    }

    @Test
    public void testQueryAwardByAwardType() {
        Integer awardType = 1;
        List<Award> awardList = awardMapper.queryAwardByAwardType(awardType);
        awardList.stream().map(JSONUtil::toJsonStr)
                .forEach(System.out::println);
    }

    @Test
    public void testQueryNextAwardId() {
        Integer awardId = awardMapper.queryNextAwardId();
        System.out.println(awardId);
    }

    @Test
    public void testBatchInsert() {
        Award award1 = Award
                .builder()
                .awardId("6")
                .awardType(2)
                .awardName("小米M13")
                .awardContent("小米13手机8G+256G").build();
        Award award2 = Award
                .builder()
                .awardId("7")
                .awardType(2)
                .awardName("小米M13 Pro")
                .awardContent("小米13Pro手机8G+256G").build();
        Award award3 = Award
                .builder()
                .awardId("8")
                .awardType(2)
                .awardName("小米耳机Buds4")
                .awardContent("小米最新蓝牙耳机").build();
        List<Award> awardList = Arrays.asList(award1,award2,award3);
        Integer count = awardMapper.batchInsert(awardList);
        System.out.println(count);
    }
}

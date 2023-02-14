package com.frankzhou.lottery.application;

import com.frankzhou.application.mq.KafkaProducer;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description Kafka消息队列 发消息 消费消息
 * @date 2023-02-14
 */
@SpringBootTest
public class KafkaTest {

    @Resource
    private KafkaProducer kafkaProducer;

    @Test
    public void testSendMessage() throws InterruptedException {
        while (true) {
            kafkaProducer.send("你好我是Kafka!");
            Thread.sleep(5000);
        }
    }
}

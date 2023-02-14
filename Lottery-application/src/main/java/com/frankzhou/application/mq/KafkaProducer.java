package com.frankzhou.application.mq;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import javax.annotation.Resource;

/**
 * @author This.FrankZhou
 * @version 1.0
 * @description 消息生产者
 * @date 2023-02-14
 */
@Slf4j
@Component
public class KafkaProducer {

    @Resource
    private KafkaTemplate<String,Object> kafkaTemplate;

    public static final String TOPIC_TEST = "Hello-Kafka";

    public static final String TOPIC_GROUP = "test-consumer-group";

    /**
     * send方法发送消息
     *
     * @author this.FrankZhou
     * @param objMsg 消息体
     * @return void
     */
    public void send(Object objMsg) {
        String obj2String = JSONUtil.toJsonStr(objMsg);
        log.info("准备发送的消息为:{}", obj2String);

        ListenableFuture<SendResult<String,Object>> future = kafkaTemplate.send(TOPIC_TEST,obj2String);
        future.addCallback(new ListenableFutureCallback<SendResult<String,Object>>() {

            // 消息成功时的处理逻辑
            @Override
            public void onSuccess(SendResult<String, Object> result) {
                log.info(TOPIC_TEST + "-生成者 发送消息成功：" + result.toString());
            }

            // 消息失败时的处理逻辑
            @Override
            public void onFailure(Throwable ex) {
                log.info(TOPIC_TEST + "-生产者 发送消息失败：" + ex.getMessage());
            }
        });
    }
}

package org.ks.kslog.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.ks.kslog.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @ClassName: LogConsumer
 * @Description:
 * @Author: yuzhipeng
 * @Date: 2019/8/19
 */

@Slf4j
@Component
public class LogConsumer {

    @Autowired
    LogService logService;

    /**
     * 监听来自各微服务的日志消息
     * @param consumerRecord
     */
    @KafkaListener(topics = {"ks-log"})
    public void receiveLogMessage(ConsumerRecord<?,?> consumerRecord) {
        //判断是否为null
        Optional<?> kafkaMessage = Optional.ofNullable(consumerRecord.value());
//        log.info(">>>>>>>>>> record =");
        if (kafkaMessage.isPresent()) {
            //得到Optional实例中的值
            Object message = kafkaMessage.get();
            //保存日志操作
            logService.saveLog(message);
            System.err.println("消费消息:" + message);
        }

    }
}

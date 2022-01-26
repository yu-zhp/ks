package org.ks.kslog.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.ks.common.util.core.MD5Utils;
import org.ks.kslog.entity.MessageIdempotency;
import org.ks.kslog.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import java.util.List;
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

    @Autowired
    MongoTemplate mongoTemplate;

    /**
     * 监听来自微服务的日志消息
     *
     * @param consumerRecord
     */
    @KafkaListener(topics = {"ks-log"})
    public void receiveLogMessage(ConsumerRecord<?, ?> consumerRecord ,Acknowledgment ack) {
        long begin = System.currentTimeMillis();
        Optional<?> kafkaMessage = Optional.ofNullable(consumerRecord.value());
        //判断是否为null
        if (!kafkaMessage.isPresent()) {
            System.err.println("消息为空");
        }
        //得到Optional实例中的值
        Object message = kafkaMessage.get();
//            log.info("消费消息:{}" , message);
        System.out.println(String.format("消费消息:{%s}", message));
        try {
            String md5 = MD5Utils.getMD5(String.valueOf(message));
            //查询消息幂等性
            List<MessageIdempotency> idempotencies = mongoTemplate.find(new Query(Criteria.where("md5").is(md5)),MessageIdempotency.class);
            if(idempotencies.size()>0){
                System.err.println(String.format("重复消费消息:{%s}", message));
                return;
            }
            //保存日志操作
            logService.saveLog(message);
            mongoTemplate.save(MessageIdempotency.newInstance(md5));
        }catch (Exception e){}
        finally {
            // 向服务器发送offset
            ack.acknowledge();
        }
    }
}

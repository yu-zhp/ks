package org.ks.kslog.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @ClassName:org.ks.kslog.entity.KafkaMessage
 * @Description:
 * @Author: yuzp
 * @Date: 2020/3/20
 */

@Data
@Document(collection = "message_idempotency")
public class MessageIdempotency {

    /**
     * id
     */
    @Id
    private String id;

    /**
     * 微服务名
     */
    @Field("md5")
    private String md5;

    public static MessageIdempotency newInstance(String md5) {
        MessageIdempotency fragment = new MessageIdempotency();
        fragment.setMd5(md5);
        return fragment;
    }
}

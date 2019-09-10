package org.ks.kslog.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: LogInfo
 * @Description:日志实体类
 * @Author: yuzhipeng
 * @Date: 2019/8/19
 */

@Data
@Document(collection = "log_info")
public class LogInfo implements Serializable {

    /**
     * id
     */
    @Id
    private String id;

    /**
     * 微服务名
     */
    @Field("micro_service")
    private String microService;

    /**
     * 日志级别
     */
    @Field("log_level")
    private String logLevel;

    /**
     * 线程名
     */
    @Field("thread_name")
    private String threadName;

    /**
     * 日志名
     */
    @Field("log_name")
    private String logName;

    /**
     * 日志信息
     */
    @Field("log_message")
    private String logMessage;

    /**
     * 时间
     */
    @Field("time")
    private Date time;

    /**
     * 异常信息
     */
    @Field("throwable")
    private String throwable;

}

package org.ks.common.core.log;

/**
 * @ClassName: LogInfo
 * @Description:日志实体
 * @Author: yuzhipeng
 * @Date: 2019/8/23
 */

import lombok.Data;
import java.io.Serializable;
import java.util.Date;

@Data
public class LogInfo implements Serializable {

    /**
     * id
     */
    private String id;

    /**
     * 微服务名
     */
    private String microService;

    /**
     * 日志级别
     */
    private String logLevel;

    /**
     * 线程名
     */
    private String threadName;

    /**
     * 日志名
     */
    private String logName;

    /**
     * 日志信息
     */
    private String logMessage;

    /**
     * 时间
     */
    private Date time;

    /**
     * 异常信息
     */
    private String throwable;

}

package org.ks.common.core.log;

import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.classic.spi.ThrowableProxy;
import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

/**
 * @ClassName: KsJsonEncode
 * @Description:
 * @Author: yuzhipeng
 * @Date: 2019/8/26
 */

public class KsJsonEncode extends PatternLayoutEncoder {

    private String microService;

    private static final LogInfo logInfo;

    /**
     * 单例模式创建日志实体
     */
    static {
        logInfo = new LogInfo();
    }

    @Override
    public byte[] encode(ILoggingEvent event) {
        return encodeLog(event).getBytes();
    }

    /**
     * 将日志转为JSON输出
     * @param iLoggingEvent
     * @return
     */
    private String encodeLog (ILoggingEvent iLoggingEvent){

        if(iLoggingEvent == null){
            return "";
        }

        logInfo.setTime(new Date(iLoggingEvent.getTimeStamp()));
        logInfo.setMicroService(microService);
        logInfo.setLogName(iLoggingEvent.getLoggerName());
        logInfo.setThreadName(iLoggingEvent.getThreadName());
        logInfo.setLogLevel(iLoggingEvent.getLevel().levelStr);
        logInfo.setLogMessage(iLoggingEvent.getMessage());

        //todo 待优化
        //如果产生异常，追加记录
        if( iLoggingEvent.getThrowableProxy() != null){
            Throwable throwable = ((ThrowableProxy)iLoggingEvent.getThrowableProxy()).getThrowable();
            logInfo.setThrowable(throwable.toString());
        }

        String logInfoStr = JSON.toJSONString(logInfo);

        return logInfoStr;
    }

    public String getMicroService() {
        return microService;
    }

    public void setMicroService(String microService) {
        this.microService = microService;
    }

}

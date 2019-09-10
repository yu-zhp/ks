package org.ks.kslog.controller;

import lombok.extern.slf4j.Slf4j;
import org.ks.common.core.result.ResultData;
import org.ks.kslog.entity.LogInfo;
import org.ks.kslog.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @ClassName: LogController
 * @Description:
 * @Author: yuzhipeng
 * @Date: 2019/8/19
 */


@Slf4j
@RestController
@RequestMapping("/log")
public class LogController {

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    LogService logService;

    @GetMapping("testMongo")
    public String testMongo(String message){
        LogInfo logInfo = new LogInfo();
        logInfo.setId("123");
        logInfo.setLogMessage(message);
        logInfo.setTime(new Date());

        mongoTemplate.save(logInfo);
        return message;
    }

    /**
     * todo 查询日志列表
     */
    @GetMapping("selectLogList")
    public ResultData selectLogList(){
        log.error("cs",new Exception("cs xinxi"));

        List<LogInfo> logs = logService.selectLogList();
        log.info("日志列表查询成功");

        return ResultData.sucess("日志列表查询成功",logs);
    }
}

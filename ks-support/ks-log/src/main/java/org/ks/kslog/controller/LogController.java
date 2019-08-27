package org.ks.kslog.controller;

import lombok.extern.slf4j.Slf4j;
import org.ks.kslog.entity.LogInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

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
    public void selectLogList(){

    }
}

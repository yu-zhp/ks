package org.ks.kslog.service.impl;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.ks.kslog.entity.LogInfo;
import org.ks.kslog.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: LogServiceImpl
 * @Description:
 * @Author: yuzhipeng
 * @Date: 2019/8/19
 */

@Slf4j
@Service
public class LogServiceImpl implements LogService {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public void saveLog(Object message) {

        LogInfo logInfo = JSON.parseObject(String.valueOf(message),LogInfo.class);
        mongoTemplate.save(logInfo);
    }

    @Override
    public List<LogInfo> selectLogList() {
        return mongoTemplate.findAll(LogInfo.class);
    }

    @Override
    public LogInfo selectLogById(String id) {
        return mongoTemplate.findById(id,LogInfo.class);
    }
}

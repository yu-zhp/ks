package org.ks.kslog.service;

import org.ks.kslog.entity.LogInfo;

import java.util.List;

/**
 * 日志业务层接口
 * yuzhipeng
 */

public interface LogService {

    void saveLog(Object message);

    List<LogInfo> selectLogList();

    LogInfo selectLogById(String id);
}

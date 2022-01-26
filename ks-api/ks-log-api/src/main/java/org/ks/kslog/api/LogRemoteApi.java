package org.ks.kslog.api;


import org.ks.common.core.result.ResultData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("/ks/log")
public interface LogRemoteApi {

    /**
     * 查询日志列表
     */
    @GetMapping("selectLogList")
    ResultData selectLogList();

    /**
     * 查询单条日志
     */
    @GetMapping("selectLogOne")
    ResultData selectLogById(@RequestParam(name = "id") String id);
}

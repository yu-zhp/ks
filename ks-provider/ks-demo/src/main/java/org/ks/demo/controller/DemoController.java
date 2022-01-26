package org.ks.demo.controller;

import org.ks.common.core.result.ResultData;
import org.ks.demo.feign.LogFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    LogFeignClient logFeignClient;

    /**
     * 查询日志列表
     */
    @GetMapping("selectLogList")
    ResultData selectLogList(){
        return logFeignClient.selectLogList();
    }

    /**
     * 查询单条日志
     */
    @GetMapping("selectLogOne")
    ResultData selectLogById(@RequestParam(name = "id") String id){
        return logFeignClient.selectLogById(id);
    }
}

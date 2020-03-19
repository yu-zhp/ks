package org.ks.demo.feign;

import org.ks.kslog.api.LogRemoteApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("ks-log")
public interface LogFeignClient extends LogRemoteApi {
}

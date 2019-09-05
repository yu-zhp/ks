package org.ks.common.core.exception;

import org.apache.commons.lang3.StringUtils;
import org.ks.common.core.result.ResultData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName: ExceptionHandle
 * @Description:统一异常处理器
 * @Author: yuzhipeng
 * @Date: 2019/9/5
 */

@ControllerAdvice
public class KsExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(KsExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultData exception(Exception e) {
        logger.error("系统发生未知异常", e);
        return ResultData.failed(StringUtils.isNotBlank(e.getMessage()) ? e.getMessage() : "系统发生未知异常");
    }

}

package org.ks.common.core;

import org.ks.common.core.exception.KsExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: KsCoreAutoConfigure
 * @Description:自动配置类
 * @Author: yuzhipeng
 * @Date: 2019/9/5
 */

@Configuration
public class KsCoreAutoConfigure {

    @Bean
    public KsExceptionHandler ksExceptionHandler(){
        return new KsExceptionHandler();
    }

}

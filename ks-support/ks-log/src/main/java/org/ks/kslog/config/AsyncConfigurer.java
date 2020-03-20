package org.ks.kslog.config;

import com.alibaba.ttl.threadpool.TtlExecutors;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @description:
 * @author: yu-zhp
 * @create: 2019-01-30 15:09
 */
@Configuration
@EnableAsync
public class AsyncConfigurer extends AsyncConfigurerSupport {

    private static final int PROCESSORS = Runtime.getRuntime().availableProcessors();

    private static final int CORE_SIZE = PROCESSORS > 4 ? PROCESSORS : 4;

    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //核心线程池数量，方法: 返回可用处理器的Java虚拟机的数量。
        executor.setCorePoolSize(CORE_SIZE);
        //最大线程数量
        executor.setMaxPoolSize(CORE_SIZE*2);
        //线程池的队列容量
        executor.setQueueCapacity(CORE_SIZE*20);
        //线程名称的前缀
        executor.setThreadNamePrefix("Ks-Log-Async-Executor-");
        executor.setWaitForTasksToCompleteOnShutdown(true);
        //executor.setTaskDecorator(new ContextDecorator());
        // setRejectedExecutionHandler：当pool已经达到max size的时候，如何处理新任务
        // CallerRunsPolicy：不在新线程中执行任务，而是由调用者所在的线程来执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        return TtlExecutors.getTtlExecutor(executor);
    }
}
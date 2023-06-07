package kr.co.ejyang.main_api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

// 실행 Thread 선언
@EnableAsync
@Configuration
public class ThreadConfig {

    /*******************************************************************************************
     * < Tread 1 >
     *  - 1번 쓰레드
     *******************************************************************************************/
    @Bean
    public ThreadPoolTaskExecutor sampleThreadA() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();

        executor.setCorePoolSize(10);
        executor.setMaxPoolSize(100);
        executor.setQueueCapacity(10);
        executor.setThreadNamePrefix("sampleThreadA");
        executor.initialize();

        return executor;
    }

    /*******************************************************************************************
     * < Tread 2 >
     *  - 2번 쓰레드
     *******************************************************************************************/
    @Bean
    public ThreadPoolTaskExecutor sampleThreadB() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();

        executor.setCorePoolSize(10);
        executor.setMaxPoolSize(100);
        executor.setQueueCapacity(10);
        executor.setThreadNamePrefix("sampleThreadB");
        executor.initialize();

        return executor;
    }
}
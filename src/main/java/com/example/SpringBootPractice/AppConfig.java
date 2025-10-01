package com.example.SpringBootPractice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
public class AppConfig {

    // During application start up it sees that we have created this bean for ThreadPoolTaskExecutor, thus uses it while
    // setting the pool executor

    // It will work with @Async(i.e. without any name) or with name @Async("myThreadPoolExecutor")
    @Bean(name="myThreadPoolExecutor")
    public Executor taskPoolExecutor() {
        int minPoolSize = 2;
        int maxPoolSize = 8;
        int queueSize = 3;

        ThreadPoolTaskExecutor poolTaskExecutor = new ThreadPoolTaskExecutor();
        poolTaskExecutor.setCorePoolSize(minPoolSize);
        poolTaskExecutor.setMaxPoolSize(maxPoolSize);
        poolTaskExecutor.setQueueCapacity(queueSize);
        poolTaskExecutor.setThreadNamePrefix("Thread use-case - 2 - ");
        poolTaskExecutor.initialize();
        return poolTaskExecutor;
    }

}

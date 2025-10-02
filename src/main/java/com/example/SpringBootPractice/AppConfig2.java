package com.example.SpringBootPractice;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

@Configuration
public class AppConfig2 implements AsyncConfigurer {

    private ThreadPoolExecutor poolExecutor;

    @Override
    public synchronized Executor getAsyncExecutor() {
        if(poolExecutor==null) {
            poolExecutor = new ThreadPoolExecutor(2, 4, 1, TimeUnit.HOURS,
                    new ArrayBlockingQueue<>(3), new CustomThreadFactory2());
        }
        return poolExecutor;
    }
}


class CustomThreadFactory2 implements ThreadFactory {
    private final AtomicInteger threadNumber = new AtomicInteger(1);

    @Override
    public Thread newThread(Runnable r) {
        Thread th = new Thread(r);
        th.setName("Default Thread-" + threadNumber.getAndIncrement());
        return th;
    }
}


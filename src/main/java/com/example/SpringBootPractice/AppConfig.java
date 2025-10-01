package com.example.SpringBootPractice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

@Configuration
public class AppConfig implements AsyncConfigurer {


//    // Use case 2
//    // --------------
//    // During application start up it sees that we have created this bean for ThreadPoolTaskExecutor, thus uses it while
//    // setting the pool executor
//
//    // It will work with @Async(i.e. without any name) or with name @Async("myThreadPoolExecutor")
//    @Bean(name="myThreadPoolExecutor")
//    public Executor taskPoolExecutor() {
//        int minPoolSize = 2;
//        int maxPoolSize = 8;
//        int queueSize = 3;
//
//        ThreadPoolTaskExecutor poolTaskExecutor = new ThreadPoolTaskExecutor();
//        poolTaskExecutor.setCorePoolSize(minPoolSize);
//        poolTaskExecutor.setMaxPoolSize(maxPoolSize);
//        poolTaskExecutor.setQueueCapacity(queueSize);
//        poolTaskExecutor.setThreadNamePrefix("Thread use-case - 2 - ");
//        poolTaskExecutor.initialize();
//        return poolTaskExecutor;
//    }
//
//
//    /*
//    Output when the simpleAsync API is called:
//    -----------------------------------
//    Inside getMethod:
//    Thread Thread use-case - 2 - 1
//    Inside getMethod:
//    Thread Thread use-case - 2 - 2
//    Inside getMethod:
//    Thread Thread use-case - 2 - 1
//    Inside getMethod:
//    Thread Thread use-case - 2 - 2
//    Inside getMethod:
//    Thread Thread use-case - 2 - 1
//    Inside getMethod:
//    Thread Thread use-case - 2 - 2
//    -----------------------------------
//    */


    /* Use case 3
     --------------
     - In this we are going to create a ThreadPoolExecutor(java) and use this.
     - Now when the application start up, the SpringBoot sees that ThreadPoolExecutor(java)
     is present thus it doesn't create a ThreadPoolTaskExecutor(spring wrapper one)
     instead it sets to default SimpleAsyncTaskExecutor.
     - Now when we call any API with @Async annotation, the SimpleAsyncTaskExecutor ThreadPool is used.
     - If we want to use our custom ThreadPoolExecutor, we will have to mention its name too
     i.e.@Async("myThreadPoolExecutor")
    */

    @Bean(name="myThreadPoolExecutor")
    public Executor taskPoolExecutor() {
        int minPoolSize = 2;
        int maxPoolSize = 8;
        int queueSize = 3;

        ThreadPoolExecutor poolTaskExecutor = new ThreadPoolExecutor(minPoolSize,maxPoolSize, 1, TimeUnit.HOURS,
                new ArrayBlockingQueue<>(queueSize), new CustomThreadFactory());
        return poolTaskExecutor;
    }


    class CustomThreadFactory implements ThreadFactory {
        private final AtomicInteger threadNo = new AtomicInteger(1);

        @Override
        public Thread newThread(Runnable r){
            Thread th = new Thread(r);
            th.setName("Custom Thread"+threadNo.getAndIncrement());
            return th;
        }
    }

    /*
    Output:
    ----------------------------
    SimpleAsyncTaskExecutor: ie @Async
        Thread SimpleAsyncTaskExecutor-1
        Inside getMethod:
        Thread SimpleAsyncTaskExecutor-2
        Inside getMethod:
        Thread SimpleAsyncTaskExecutor-3
        Inside getMethod:
        Thread SimpleAsyncTaskExecutor-4
        Inside getMethod:
        Thread SimpleAsyncTaskExecutor-5

    --------------------------------
    Custom ThreadExecutorTask
        Thread UseCase 3 ˳- Custom Thread1
        Inside getMethod:
        Thread UseCase 3 ˳- Custom Thread2
        Inside getMethod:
        Thread UseCase 3 ˳- Custom Thread1
        Inside getMethod:
        Thread UseCase 3 ˳- Custom Thread2
        Inside getMethod:
        Thread UseCase 3 ˳- Custom Thread1
    ----------------------------
     */

}

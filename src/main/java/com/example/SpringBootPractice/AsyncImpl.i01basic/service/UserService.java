package com.example.SpringBootPractice.AsyncImpl.i01basic.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Async
    public void asyncMethod() {
        System.out.println("Thread "+Thread.currentThread().getName());
    }

    @Async("myThreadPoolExecutor")
    public void asyncMethod2() {
        System.out.println("Thread UseCase 3 ˳- "+Thread.currentThread().getName());
    }
}

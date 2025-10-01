package com.example.SpringBootPractice.AsyncImpl.i01basic;

import com.example.SpringBootPractice.AsyncImpl.i01basic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/asyncImpl/v1.0")
public class SimpleController {


    @Autowired
    UserService userService;
    // Use case 1: When we dont specify any thread pool task executor, spring creates ThreadPoolTaskExecutor of
    // default size 8 min pool size, max pool = Integer.MAX_VALUE, queue of Integer.MAX_VALUE


    // reference: AsyncExecutionInterceptor => getDefaultExecutor
    // ThreadPoolTaskExecutor => initializeExecutor
    @GetMapping("/simpleAsync")
    public String getSimpleAsyncMethod() {
        System.out.println("Inside getMethod:");
        userService.asyncMethod();
        return "AsyncMethod Called";
    }
}

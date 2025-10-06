package com.example.SpringBootPractice.customInterceptor.beforeController.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/custom/")
public class CustomInterceptorController {
    @GetMapping("health")
    public boolean healthCheck() {
        System.out.println("Inside HealthCheck");
        return true;
    }

    @GetMapping("/testing")
    public void testing() {
        System.out.println("Inside testing");
    }
}

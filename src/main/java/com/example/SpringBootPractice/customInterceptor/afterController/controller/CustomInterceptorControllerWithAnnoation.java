package com.example.SpringBootPractice.customInterceptor.beforeController.controller;

import com.example.SpringBootPractice.customInterceptor.afterController.service.CustomInterceptorwithAnnotationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/custom2/")
public class CustomInterceptorControllerWithAnnoation {

    @Autowired
    CustomInterceptorwithAnnotationService service;

    @GetMapping("/testing")
    public void testing() {
        System.out.println("Inside testing");
        service.testingMethod();
    }
}

package com.example.SpringBootPractice.customInterceptor.afterController.service;

import com.example.SpringBootPractice.customInterceptor.afterController.annotation.CustomAnnotation;
import org.springframework.stereotype.Service;

@Service
public class CustomInterceptorwithAnnotationService {
    @CustomAnnotation
    public void testingMethod() {
        System.out.println("Inside testing Method");
    }
}
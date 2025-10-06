package com.example.SpringBootPractice.customInterceptor.afterController.intereceptor;

import com.example.SpringBootPractice.customInterceptor.afterController.annotation.CustomAnnotation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;


@Component
@Aspect
public class CustomInterceptorAfterController {

    @Around("@annotation(com.example.SpringBootPractice.customInterceptor.afterController.annotation.CustomAnnotation)")
    public void invoke(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Before intereception");

        Method method = ((MethodSignature)joinPoint.getSignature()).getMethod();
        if(method.isAnnotationPresent(CustomAnnotation.class)) {
            CustomAnnotation custAnno = method.getAnnotation(CustomAnnotation.class);
            System.out.println("Annotation class:" + custAnno.name());
        }

        joinPoint.proceed();
        System.out.println("After intereception");
    
    }
}
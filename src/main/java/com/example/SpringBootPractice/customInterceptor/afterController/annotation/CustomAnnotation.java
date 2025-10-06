package com.example.SpringBootPractice.customInterceptor.afterController.annotation;

import com.example.SpringBootPractice.customInterceptor.afterController.enums.MyCustomEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomAnnotation {
    int key() default 0;
    String name() default "";
    Class<?> classTypeKey() default String.class;
    MyCustomEnum enumKey() default MyCustomEnum.EnumKey_1;
    String[] stringArrayKey() default {"key1", "key2"};
    int[] intArrayKey() default {1, 1};
}
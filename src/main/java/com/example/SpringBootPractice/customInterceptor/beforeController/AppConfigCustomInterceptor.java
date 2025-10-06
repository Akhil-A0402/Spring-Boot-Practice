package com.example.SpringBootPractice.customInterceptor.beforeController;

import com.example.SpringBootPractice.customInterceptor.beforeController.interceptor.MyCustomInterceptor;
import com.example.SpringBootPractice.customInterceptor.beforeController.interceptor.MyCustomInterceptor2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfigCustomInterceptor implements WebMvcConfigurer {

    @Autowired
    MyCustomInterceptor myCustomInterceptor;

    @Autowired
    MyCustomInterceptor2 myCustomInterceptor2;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myCustomInterceptor)
                .addPathPatterns("/api/v1/custom/*") // we defined the paths to add the custom interceptor
                .excludePathPatterns("/api/v1/custom/health", "/api/v1/custom/status"); // listed the paths to exclude

        registry.addInterceptor(myCustomInterceptor2)
                .addPathPatterns("/api/v1/custom/*") // we defined the paths to add the custom interceptor
                .excludePathPatterns("/api/v1/custom/health"); // listed the paths to exclude
    }

}

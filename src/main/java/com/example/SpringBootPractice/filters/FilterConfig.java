package com.example.SpringBootPractice.filters;

import com.example.SpringBootPractice.filters.filter.Filter1;
import com.example.SpringBootPractice.filters.filter.Filter2;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<Filter1> myFirstFilter() {
        FilterRegistrationBean<Filter1> filter1FilterRegistrationBean = new FilterRegistrationBean<>();
        filter1FilterRegistrationBean.setFilter(new Filter1());
        filter1FilterRegistrationBean.addUrlPatterns("/*");
        filter1FilterRegistrationBean.setOrder(2);
        return filter1FilterRegistrationBean;
    }

   @Bean
   public FilterRegistrationBean<Filter2> mySecondFilter() {
       FilterRegistrationBean<Filter2> filter2FilterRegistrationBean = new FilterRegistrationBean<>();
       filter2FilterRegistrationBean.setFilter(new Filter2());
       filter2FilterRegistrationBean.addUrlPatterns("/*");
       filter2FilterRegistrationBean.setOrder(1);
       return filter2FilterRegistrationBean;
   }
}

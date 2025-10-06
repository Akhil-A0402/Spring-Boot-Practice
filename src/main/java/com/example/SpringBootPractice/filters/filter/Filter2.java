package com.example.SpringBootPractice.filters.filter;

import jakarta.servlet.*;

import java.io.IOException;

public class Filter2 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Filter2 inside");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("Filter2 completed");
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}

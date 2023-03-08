package com.subhajit.sbmiscconcepts.interceptor.config;

import com.subhajit.sbmiscconcepts.interceptor.interceptors.InterceptorOne;
import com.subhajit.sbmiscconcepts.interceptor.interceptors.InterceptorTwo;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new InterceptorOne())
                .addPathPatterns("/interceptor-method1");

        registry.addInterceptor(new InterceptorTwo())
                .addPathPatterns("/interceptor-method2")
                .addPathPatterns("/interceptor-exception");


    }
}

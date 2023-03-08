package com.subhajit.sbmiscconcepts.filter.config;

import com.subhajit.sbmiscconcepts.filter.filters.FilterOne;
import com.subhajit.sbmiscconcepts.filter.filters.FilterTwo;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<FilterOne> filterOne(){
        FilterRegistrationBean<FilterOne> filterOneRegistrationBean
                = new FilterRegistrationBean<>();

        filterOneRegistrationBean.setFilter(new FilterOne());
        filterOneRegistrationBean.addUrlPatterns("/filter-method1");
        filterOneRegistrationBean.setOrder(1);

        return filterOneRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean<FilterTwo> filterTwo(){
        FilterRegistrationBean<FilterTwo> filterTwoRegistrationBean
                = new FilterRegistrationBean<>();

        filterTwoRegistrationBean.setFilter(new FilterTwo());
        filterTwoRegistrationBean.addUrlPatterns("/filter-method2");
        filterTwoRegistrationBean.addUrlPatterns("/filter-exception");
        filterTwoRegistrationBean.setOrder(1);

        return filterTwoRegistrationBean;
    }
}

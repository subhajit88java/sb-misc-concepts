package com.subhajit.sbmiscconcepts.filter.filters;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

//@Component // This filter will be attached with every urls if @Component is mentioned
@Order(1)
public class FilterOne implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Filter One starts.................");
        chain.doFilter(request, response);
        System.out.println("Filter One ends.................");
    }
}

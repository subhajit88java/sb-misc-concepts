package com.subhajit.sbmiscconcepts.thread.asynch.config;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

import java.lang.reflect.Method;

public class AsyncExceptionHandler implements AsyncUncaughtExceptionHandler {

    @Override
    public void handleUncaughtException(Throwable ex, Method method, Object... params) {
        System.out.println("EXCEPTION >>>>>>>>>>> " + method.getDeclaringClass().getName() + "." + method.getName());
    }
}

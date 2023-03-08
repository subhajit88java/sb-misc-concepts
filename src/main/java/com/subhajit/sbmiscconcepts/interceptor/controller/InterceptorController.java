package com.subhajit.sbmiscconcepts.interceptor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InterceptorController {

    @GetMapping("/interceptor-method1")
    public String method1(){
        System.out.println("In InterceptorController method1.................");
        return "method1";
    }

    @GetMapping("/interceptor-method2")
    public String method2(){
        System.out.println("In InterceptorController method2.................");
        return "method2";
    }

    @GetMapping("/interceptor-exception")
    public String exception(){
        System.out.println("In InterceptorController exception.................");
        String s = null;
        s.length();
        return "exception";
    }

}

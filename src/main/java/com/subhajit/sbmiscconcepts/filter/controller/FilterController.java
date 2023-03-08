package com.subhajit.sbmiscconcepts.filter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilterController {

    @GetMapping("/filter-method1")
    public String method1(){
        System.out.println("In FilterController method1.................");
        return "method1";
    }

    @GetMapping("/filter-method2")
    public String method2(){
        System.out.println("In FilterController method2.................");
        return "method2";
    }

    @GetMapping("/filter-exception")
    public String exception(){
        System.out.println("In FilterController exception.................");
        String s = null;
        s.length();
        return "exception";
    }
}

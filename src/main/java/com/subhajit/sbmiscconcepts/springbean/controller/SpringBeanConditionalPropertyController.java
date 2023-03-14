package com.subhajit.sbmiscconcepts.springbean.controller;

import com.subhajit.sbmiscconcepts.springbean.config.ConditionalPropertyBeanInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringBeanConditionalPropertyController {

    @Autowired
    private ConditionalPropertyBeanInterface conditionalPropertyBeanInterface;

    @GetMapping("/test-conditional-property")
    public String testConditionalProperty(){
        return conditionalPropertyBeanInterface.connectDatabase();
    }
}

package com.subhajit.sbmiscconcepts.di.controller;

import com.subhajit.sbmiscconcepts.di.beans.BeanInterface;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestFieldInjectControllerOne {
    @Resource
    private BeanInterface bone;

    @GetMapping("/test-di-field-res-one")
    public String testDiFour(){
        System.out.println("In TestFieldInjectControllerOne, bone : " + System.identityHashCode(bone));
        bone.printBeanName();
        return "Success!";
    }

}

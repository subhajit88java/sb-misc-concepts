package com.subhajit.sbmiscconcepts.di.controller;

import com.subhajit.sbmiscconcepts.di.beans.BeanInterface;
import com.subhajit.sbmiscconcepts.di.beans.BeanInterface2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.inject.Inject;

@RestController
public class TestFieldInjectControllerOne {
    @Resource
    private BeanInterface bone;

    @Resource
    private BeanInterface btwo;

    @Inject
    private BeanInterface2 bThree;

    @GetMapping("/test-di-field-res-one")
    public String testDiFour(){
        System.out.println("In TestFieldInjectControllerOne, bone : " + System.identityHashCode(bone));
        System.out.println("In TestFieldInjectControllerOne, btwo : " + System.identityHashCode(btwo));
        System.out.println("In TestFieldInjectControllerOne, bThree : " + System.identityHashCode(bThree));
        bone.printBeanName();
        btwo.printBeanName();
        bThree.printBeanName();
        return "Success!";
    }

}

package com.subhajit.sbmiscconcepts.di.controller;

import com.subhajit.sbmiscconcepts.di.beans.BeanInterface;
import com.subhajit.sbmiscconcepts.di.beans.BeanOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestDiController {
    @Autowired
    private BeanInterface bone;

    @Autowired
    private BeanInterface btwo;

//    @Autowired
//    public TestDiController(BeanInterface bone,BeanInterface btwo){
//        System.out.println("In TestDiController, constructor : " + System.identityHashCode(btwo));
//        this.bean = btwo;
//    }


    @GetMapping("/test-di")
    public String testDi(){
        System.out.println("In TestDiController, bone : " + System.identityHashCode(bone));
        System.out.println("In TestDiController, btwo : " + System.identityHashCode(btwo));
        bone.printBeanName();
        btwo.printBeanName();
        return "Success!";
    }

}

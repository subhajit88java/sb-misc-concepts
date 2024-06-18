package com.subhajit.sbmiscconcepts.di.controller;

import com.subhajit.sbmiscconcepts.di.beans.BeanInterface;
import com.subhajit.sbmiscconcepts.di.beans.BeanInterface2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestSetterAutowireControllerFour {
    private BeanInterface one;
    private BeanInterface two;
    private BeanInterface2 three;

    @GetMapping("/test-di-setter-one")
    public String testDiFour(){
        System.out.println("In TestSetterAutowireControllerFour, bone : " + System.identityHashCode(one));
        System.out.println("In TestSetterAutowireControllerFour, btwo : " + System.identityHashCode(two));
        System.out.println("In TestSetterAutowireControllerFour, bthree : " + System.identityHashCode(three));
        one.printBeanName();
        two.printBeanName();
        three.printBeanName();
        return "Success!";
    }
   /* @Autowired
    public void setOne(@Qualifier("bone") BeanInterface one) {
        this.one = one;
    }
    @Autowired
    public void setTwo(@Qualifier("btwo")BeanInterface two) {
        this.two = two;
    }

    @Autowired
    public void setThree(BeanInterface2 three) {
        this.three = three;
    }*/
}

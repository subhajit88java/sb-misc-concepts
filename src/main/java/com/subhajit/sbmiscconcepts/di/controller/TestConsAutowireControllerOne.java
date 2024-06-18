package com.subhajit.sbmiscconcepts.di.controller;

import com.subhajit.sbmiscconcepts.di.beans.BeanInterface;
import com.subhajit.sbmiscconcepts.di.beans.BeanInterface2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// A class can have only one constructor with @Autowired
// Autowired constructors also follows the same hierarchy :
// 1. Variable name
// 2. variable type
@RestController
public class TestConsAutowireControllerOne {
    private BeanInterface constructorBeanOne;
    private BeanInterface constructorBeanTwo;
    private BeanInterface2 constructorBeanThree;
    /*@Autowired
    public TestConsAutowireControllerOne(BeanInterface bone){
        System.out.println("In TestConsAutowireControllerOne, constructor 1 : " + System.identityHashCode(bone));
        this.constructorBeanOne = bone;
    }*/
   /* @Autowired
    public TestConsAutowireControllerOne(@Qualifier("bone") BeanInterface one,@Qualifier("btwo") BeanInterface two, BeanInterface2 three){
        System.out.println("In TestConsAutowireControllerOne, constructor 2, bone : " + System.identityHashCode(one));
        System.out.println("In TestConsAutowireControllerOne, constructor 2, btwo : " + System.identityHashCode(two));
        System.out.println("In TestConsAutowireControllerOne, constructor 2, bthree : " + System.identityHashCode(three));
        this.constructorBeanOne = one;
        this.constructorBeanTwo = two;
        this.constructorBeanThree = three;
    }*/
    /*@GetMapping("/test-di-cons-one")
    public String testDiThree(){
        System.out.println("In TestConsAutowireControllerOne, bone : " + System.identityHashCode(constructorBeanOne));
        System.out.println("In TestConsAutowireControllerOne, btwo : " + System.identityHashCode(constructorBeanTwo));
        System.out.println("In TestConsAutowireControllerOne, bthree : " + System.identityHashCode(constructorBeanThree));
        constructorBeanOne.printBeanName();
        constructorBeanTwo.printBeanName();
        constructorBeanThree.printBeanName();
        return "Success!";
    }*/
}

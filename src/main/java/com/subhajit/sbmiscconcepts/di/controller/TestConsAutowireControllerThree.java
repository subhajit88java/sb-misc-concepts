package com.subhajit.sbmiscconcepts.di.controller;

import com.subhajit.sbmiscconcepts.di.beans.BeanInterface;
import com.subhajit.sbmiscconcepts.di.beans.BeanInterface2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;

// Even if we mention @Autowired as prefix to the constructor arguments, it works
@RestController
public class TestConsAutowireControllerThree {
    private BeanInterface constructorBeanOne;
    private BeanInterface constructorBeanTwo;
    private BeanInterface2 constructorBeanThree;

    /*public TestConsAutowireControllerThree(@Autowired BeanInterface2 three){
        System.out.println("In TestConsAutowireControllerThree, constructor 1 : " + System.identityHashCode(three));
        this.constructorBeanThree = three;
    }*/

   /* public TestConsAutowireControllerThree(@Autowired @Qualifier("bone") BeanInterface one, @Autowired @Qualifier("btwo") BeanInterface two, @Autowired BeanInterface2 three){
        System.out.println("In TestConsAutowireControllerThree, constructor 2, bone : " + System.identityHashCode(one));
        System.out.println("In TestConsAutowireControllerThree, constructor 2, btwo : " + System.identityHashCode(two));
        System.out.println("In TestConsAutowireControllerThree, constructor 2, bthree : " + System.identityHashCode(three));
        this.constructorBeanOne = one;
        this.constructorBeanTwo = two;
        this.constructorBeanThree = three;
    }*/
}

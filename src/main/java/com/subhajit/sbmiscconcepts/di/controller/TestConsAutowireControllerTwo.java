package com.subhajit.sbmiscconcepts.di.controller;

import com.subhajit.sbmiscconcepts.di.beans.BeanInterface;
import com.subhajit.sbmiscconcepts.di.beans.BeanInterface2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Even if we don't mention @Autowired on constructor, still it will work
// Parameterized multi-constructor should not be there, otherwise exception will be thrown - finding for default constructor
// If we mention default constructor then the parameterized constructor will not get executed, thus failing the DI
@RestController
public class TestConsAutowireControllerTwo {
    private BeanInterface constructorBeanOne;
    private BeanInterface constructorBeanTwo;
    private BeanInterface2 constructorBeanThree;

    /*public TestConsAutowireControllerTwo(BeanInterface bone){
        System.out.println("In TestConsAutowireControllerTwo, constructor 1 : " + System.identityHashCode(bone));
        this.constructorBeanOne = bone;
    }*/

    /*public TestConsAutowireControllerTwo(BeanInterface bone,BeanInterface btwo,BeanInterface2 three){
        System.out.println("In TestConsAutowireControllerTwo, constructor 2, bone : " + System.identityHashCode(bone));
        System.out.println("In TestConsAutowireControllerTwo, constructor 2, btwo : " + System.identityHashCode(btwo));
        System.out.println("In TestConsAutowireControllerTwo, constructor 2, bthree : " + System.identityHashCode(three));
        this.constructorBeanOne = bone;
        this.constructorBeanTwo = btwo;
        this.constructorBeanThree = three;
    }*/
   /* @GetMapping("/test-di-cons-two")
    public String testDiThree(){
        System.out.println("In TestConsAutowireControllerTwo, bone : " + System.identityHashCode(constructorBeanOne));
        System.out.println("In TestConsAutowireControllerTwo, btwo : " + System.identityHashCode(constructorBeanTwo));
        System.out.println("In TestConsAutowireControllerTwo, bthree : " + System.identityHashCode(constructorBeanThree));
        constructorBeanOne.printBeanName();
        constructorBeanTwo.printBeanName();
        constructorBeanThree.printBeanName();
        return "Success!";
    }*/
}

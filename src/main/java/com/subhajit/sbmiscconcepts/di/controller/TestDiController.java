package com.subhajit.sbmiscconcepts.di.controller;

import com.subhajit.sbmiscconcepts.di.beans.BeanInterface;
import com.subhajit.sbmiscconcepts.di.beans.BeanInterface2;
import com.subhajit.sbmiscconcepts.di.beans.BeanOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

// Precedence of Autowiring :
// 1. Variable name
// 2. Variable type
// 3.

@RestController
public class TestDiController {
   //@Autowired
   //private BeanInterface bone;

  // @Autowired
   //private BeanInterface btwo;

   // @Autowired
   // private BeanInterface2 bthree;

   // @Autowired
   // private List<BeanInterface> listOfBeans;

    //@Autowired
    //@Qualifier("btwo")
    //private BeanInterface  bean;




    // Type same(BeanInterface), variable different(bone and btwo), bean name same(bone - bone, btwo-btwo)
    @GetMapping("/test-di-one")
    public String testDiOne(){
       // System.out.println("In TestDiController, bone : " + System.identityHashCode(bone));
       // System.out.println("In TestDiController, btwo : " + System.identityHashCode(btwo));
       // bone.printBeanName();
       // btwo.printBeanName();
        return "Success!";
    }

    // Type same(BeanInterface), variable different(bone and btwo), bean name different(bone - bone1, btwo-btwo2)
    // Result  Exception
    @GetMapping("/test-di-two")
    public String testDiTwo(){
        //System.out.println("In TestDiController, bone : " + System.identityHashCode(bone1));
        //System.out.println("In TestDiController, btwo : " + System.identityHashCode(btwo2));
        //bone1.printBeanName();
        //btwo2.printBeanName();
        return "Success!";
    }


    @GetMapping("/test-di-four")
    public String testDiFour(){
       // System.out.println("In TestDiController, bean : " + System.identityHashCode(bean));
       // bean.printBeanName();
        return "Success!";
    }



    @GetMapping("/test-di-five")
    public String testDiFive(){
        //System.out.println("In TestDiController, bone : " + System.identityHashCode(bone));
        //System.out.println("In TestDiController, btwo : " + System.identityHashCode(btwo));
        //System.out.println("In TestDiController, bthree : " + System.identityHashCode(bthree));
        //bone.printBeanName();
        //btwo.printBeanName();
       // bthree.printBeanName();
        return "Success!";
    }



}

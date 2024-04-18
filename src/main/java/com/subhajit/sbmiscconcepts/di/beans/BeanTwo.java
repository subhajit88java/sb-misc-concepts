package com.subhajit.sbmiscconcepts.di.beans;

import org.springframework.stereotype.Component;

@Component(value = "btwo")
public class BeanTwo implements BeanInterface{
    {
        System.out.println("BeanTwo instance created!! " + System.identityHashCode(this));
    }
    public void printBeanName(){
        System.out.println("BeanTwo!! ");
    }
}

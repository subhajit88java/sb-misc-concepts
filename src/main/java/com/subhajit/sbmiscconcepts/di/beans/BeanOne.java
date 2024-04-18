package com.subhajit.sbmiscconcepts.di.beans;

import org.springframework.stereotype.Component;

@Component(value = "bone")
public class BeanOne implements BeanInterface{
    {
        System.out.println("BeanOne instance created!! " + System.identityHashCode(this));
    }

    @Override
    public void printBeanName(){
        System.out.println("BeanOne!! ");
    }
}

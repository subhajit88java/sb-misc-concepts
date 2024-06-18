package com.subhajit.sbmiscconcepts.di.beans;

import org.springframework.stereotype.Component;

@Component
public class BeanThree implements BeanInterface2{
    {
        System.out.println("BeanThree instance created!! " + System.identityHashCode(this));
    }

    @Override
    public void printBeanName(){
        System.out.println("BeanThree!! ");
    }
}

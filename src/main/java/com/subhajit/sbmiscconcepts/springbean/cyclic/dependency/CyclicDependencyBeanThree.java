package com.subhajit.sbmiscconcepts.springbean.cyclic.dependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class CyclicDependencyBeanThree {
    static{
        System.out.println("CyclicDependencyBeanThree loaded : " + System.currentTimeMillis());
    }
    {
        System.out.println("CyclicDependencyBeanThree instance created : " + System.identityHashCode(this));
    }
    @Autowired
    private CyclicDependencyBeanOne cyclicDependencyBeanOne;

    @PostConstruct
    public void printInjectedBean(){
        System.out.println("CyclicDependencyBeanThree injected bean : " + System.identityHashCode(cyclicDependencyBeanOne));
    }

}

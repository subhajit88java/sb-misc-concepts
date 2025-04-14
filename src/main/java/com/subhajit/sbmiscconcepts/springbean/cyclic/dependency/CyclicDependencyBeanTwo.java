package com.subhajit.sbmiscconcepts.springbean.cyclic.dependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class CyclicDependencyBeanTwo {
    static{
        System.out.println("CyclicDependencyBeanTwo loaded : " + System.currentTimeMillis());
    }
    {
        System.out.println("CyclicDependencyBeanTwo instance created : " + System.identityHashCode(this));
    }
    @Autowired
    @Lazy
    private CyclicDependencyBeanThree cyclicDependencyBeanThree;

    @PostConstruct
    public void printInjectedBean(){
        System.out.println("CyclicDependencyBeanTwo injected bean : " + System.identityHashCode(cyclicDependencyBeanThree));
    }

}

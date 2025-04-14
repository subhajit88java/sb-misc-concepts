package com.subhajit.sbmiscconcepts.springbean.cyclic.dependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class CyclicDependencyBeanOne {

    static{
        System.out.println("CyclicDependencyBeanOne loaded : " + System.currentTimeMillis());
    }
    {
        System.out.println("CyclicDependencyBeanOne instance created : " + System.identityHashCode(this));
    }
    @Autowired
    @Lazy
    private CyclicDependencyBeanTwo cyclicDependencyBeanTwo;

    @PostConstruct
    public void printInjectedBean(){
        System.out.println("CyclicDependencyBeanOne injected bean : " + System.identityHashCode(cyclicDependencyBeanTwo));
    }

}

// Solutions :
// 1. spring.main.allow-circular-references=true in application.properties
// 2. Using @Lazy with @Autowired so that a proxy is injected instead of actual bean during start-up

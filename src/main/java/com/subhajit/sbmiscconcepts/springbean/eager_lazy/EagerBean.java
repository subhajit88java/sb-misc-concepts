package com.subhajit.sbmiscconcepts.springbean.eager_lazy;

import org.springframework.stereotype.Component;

@Component
public class EagerBean {
    static{
        System.out.println("EagerBean loaded..................");
    }
    {
        System.out.println("EagerBean instance created : " + System.identityHashCode(this));
    }
    public void method(){
        System.out.println("EagerBean!!");
    }
}

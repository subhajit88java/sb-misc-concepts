package com.subhajit.sbmiscconcepts.springbean.eager_lazy;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy // Until and unless this is not injected somewhere else, this class will neither be loaded nor instance gets created
public class LazyBean {
    static{
        System.out.println("LazyBean loaded..................");
    }
    {
        System.out.println("LazyBean instance created : " + System.identityHashCode(this));
    }
    public void method(){
        System.out.println("LazyBean!!");
    }
}

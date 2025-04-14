package com.subhajit.sbmiscconcepts.springbean.controller;

import com.subhajit.sbmiscconcepts.springbean.eager_lazy.EagerBean;
import com.subhajit.sbmiscconcepts.springbean.eager_lazy.LazyBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringBeanEagerLazyController {
    @Autowired
    private EagerBean eagerBean;

   @Autowired
   @Lazy // Instance will be created and injected once a method is called on this instance.However the class will be loaded. Initially a proxy will be injected
   private LazyBean lazyBean;

    @GetMapping("/eager-bean")
    public String eagerBean(){
        eagerBean.method();
        return "EagerBean";
    }

    @GetMapping("/lazy-bean")
    public String lazyBean(){
       // lazyBean.method();
        return "LazyBean";
    }
}

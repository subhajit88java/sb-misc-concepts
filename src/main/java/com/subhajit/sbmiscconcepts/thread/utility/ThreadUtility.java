package com.subhajit.sbmiscconcepts.thread.utility;

import org.springframework.stereotype.Component;

@Component
public class ThreadUtility {
    public void testThreadFlow() {
        System.out.println("Utility Thread Starts.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName());

        try{
            Thread.sleep(5000);
        }catch(Exception e){}

        System.out.println("Utility Thread Ends.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName());

    }
}

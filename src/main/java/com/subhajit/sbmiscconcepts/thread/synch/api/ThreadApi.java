package com.subhajit.sbmiscconcepts.thread.synch.api;

import com.subhajit.sbmiscconcepts.thread.utility.ThreadUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ThreadApi {
    @Autowired
    private ThreadUtility threadUtility;
    public void testThreadFlow() {
        System.out.println("Api Thread Starts.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName());

        threadUtility.testThreadFlow();

        System.out.println("Api Thread Ends.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName());

    }
}

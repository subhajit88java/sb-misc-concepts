package com.subhajit.sbmiscconcepts.thread.dao;

import com.subhajit.sbmiscconcepts.thread.utility.ThreadUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ThreadDao {

    @Autowired
    private ThreadUtility threadUtility;
    public void testThreadFlow() {
        System.out.println("Dao Thread Starts.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName());

        threadUtility.testThreadFlow();

        System.out.println("Dao Thread Ends.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName());

    }
}

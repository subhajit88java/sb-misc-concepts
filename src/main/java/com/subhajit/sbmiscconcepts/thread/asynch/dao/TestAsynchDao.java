package com.subhajit.sbmiscconcepts.thread.asynch.dao;

import org.springframework.stereotype.Component;

@Component
public class TestAsynchDao {

    public void testThreadAsynch(){
        System.out.println("Dao Thread Starts.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName());

        try{
            Thread.sleep(10000);
        }catch(Exception e){}


        System.out.println("Dao Thread Ends.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName());

    }

    public void testAsynchFlowService(String flag){
        System.out.println("Dao Thread Starts.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName() + " - " + flag);

        try{
            Thread.sleep(10000);
        }catch(Exception e){}


        System.out.println("Dao Thread Ends.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName() + " - " + flag);

    }
}

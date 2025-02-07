package com.subhajit.sbmiscconcepts.thread.synch.dao;

import org.springframework.stereotype.Component;

@Component
public class TestSynchDao {

    public void testSynchFlow(String flag){
        System.out.println("Dao Thread Starts.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName() + " for flag : " + flag);

        try{
            Thread.sleep(10000);
        }catch(Exception e){}


        System.out.println("Dao Thread Ends.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName() + " for flag : " + flag);

    }

    public void testSynchFlowService(){
        System.out.println("Dao Thread Starts.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName());

        try{
            Thread.sleep(10000);
        }catch(Exception e){}


        System.out.println("Dao Thread Ends.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName());

    }

}

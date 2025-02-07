package com.subhajit.sbmiscconcepts.thread.synch.service;

import com.subhajit.sbmiscconcepts.thread.synch.api.ThreadApi;
import com.subhajit.sbmiscconcepts.thread.synch.dao.TestSynchDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class TestSynchService {

    @Autowired
    private TestSynchDao testSynchDao;

    @Autowired
    private ThreadApi threadApi;

    public void testSynchFlow(String flag){
        System.out.println("Service Thread Starts.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName() + " for flag : " + flag);

        testSynchDao.testSynchFlow(flag);

        System.out.println("Service Thread Ends.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName() + " for flag : " + flag);

    }

    public String testSynchFlowMultipleService1(){
        System.out.println("Service1 Thread Starts.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName());

        testSynchDao.testSynchFlowService();

        System.out.println("Service1 Thread Ends.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName());

        return Thread.currentThread().getId() + " - " + Thread.currentThread().getName();

    }

    public String testSynchFlowMultipleService2(){
        System.out.println("Service2 Thread Starts.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName());

        testSynchDao.testSynchFlowService();

        System.out.println("Service2 Thread Ends.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName());

        return Thread.currentThread().getId() + " - " + Thread.currentThread().getName();

    }

    @Async("asyncExecutor")
    public CompletableFuture<String> testSynchFlowServiceException(){
        System.out.println("ServiceException Thread Starts.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName());

        testSynchDao.testSynchFlowService();
        String s = null;
        s.length();

        System.out.println("ServiceException Thread Ends.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName());

        return CompletableFuture.completedFuture(Thread.currentThread().getId() + " - " + Thread.currentThread().getName());

    }

    public void testThreadUnSynch(String flag, String monitor) {
        System.out.println("In service Flag : " + flag + " - " + System.identityHashCode(monitor));
        System.out.println("Usynchronized block starts for flag ==> " + flag + " - " + monitor);
        try {
            Thread.sleep(20000);
        }catch(Exception e) {}
        System.out.println("Usynchronized block ends for flag ==> " + flag + " - " + monitor);
    }

    public void testThreadClassLvlSynchBlockOne(String flag, String monitor) {
        System.out.println("In service Flag : " + flag + " - " + System.identityHashCode(monitor));
        synchronized (monitor.getClass()) {
            System.out.println("Class level synchronized block starts for flag ==> " + flag + " - " + monitor);
            try {
                Thread.sleep(20000);
            }catch(Exception e) {}
            System.out.println("Class level synchronized block ends for flag ==> " + flag + " - " + monitor);
        }
    }

    public void testThreadClassLvlSynchBlockTwo() {
        synchronized (String.class) {
            System.out.println("Class level synchronized block starts");
            try {
                Thread.sleep(20000);
            }catch(Exception e) {}
            System.out.println("Class level synchronized block ends");
        }
    }

    public void testThreadObjectLvlSynchBlock(String flag, String monitor) {
        System.out.println("In service Flag : " + flag + " - " + System.identityHashCode(monitor));
        synchronized (monitor) {
            System.out.println("Object level synchronized block starts for flag ==> " + flag + " - " + monitor);
            try {
                Thread.sleep(20000);
            }catch(Exception e) {}
            System.out.println("Object level synchronized block ends for flag ==> " + flag + " - " + monitor);
        }
    }

}

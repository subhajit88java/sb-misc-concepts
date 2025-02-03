package com.subhajit.sbmiscconcepts.thread.asynch.service;

import com.subhajit.sbmiscconcepts.thread.asynch.dao.TestAsynchDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class TestAsynchService {

    @Autowired
    private TestAsynchDao testAsynchDao;

    public void testThreadAsynch(String flag) {
        System.out.println("Service Thread Starts.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName() + " for flag => " + flag);
        try {
            Thread.sleep(5000);
        }catch(Exception e) {}

        System.out.println("Service Thread Ends.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName() + " for flag => " + flag);
    }

    public void testAsynchFlowController(){
        System.out.println("Service Thread Starts.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName());

        testAsynchDao.testAsynchFlowController();

        System.out.println("Service Thread Ends.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName());

    }
    @Async("asyncExecutor")
    public CompletableFuture<String> testAsynchFlowService(){
        System.out.println("Service Thread Starts.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName());

        testAsynchDao.testAsynchFlowService();

        System.out.println("Service Thread Ends.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName());

        return CompletableFuture.completedFuture(Thread.currentThread().getId() + " - " + Thread.currentThread().getName());

    }

    @Async("asyncExecutor")
    public CompletableFuture<String> testAsynchFlowMultipleService1(){
        System.out.println("Service1 Thread Starts.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName());

        testAsynchDao.testAsynchFlowService();

        System.out.println("Service1 Thread Ends.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName());

        return CompletableFuture.completedFuture(Thread.currentThread().getId() + " - " + Thread.currentThread().getName());

    }

    @Async("asyncExecutor")
    public CompletableFuture<String> testAsynchFlowMultipleService2(){
        System.out.println("Service2 Thread Starts.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName());

        testAsynchDao.testAsynchFlowService();

        System.out.println("Service2 Thread Ends.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName());

        return CompletableFuture.completedFuture(Thread.currentThread().getId() + " - " + Thread.currentThread().getName());

    }

    @Async("asyncExecutor")
    public CompletableFuture<String> testAsynchFlowServiceException(){
        System.out.println("ServiceException Thread Starts.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName());

        testAsynchDao.testAsynchFlowService();
        String s = null;
        s.length();

        System.out.println("ServiceException Thread Ends.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName());

        return CompletableFuture.completedFuture(Thread.currentThread().getId() + " - " + Thread.currentThread().getName());

    }
}

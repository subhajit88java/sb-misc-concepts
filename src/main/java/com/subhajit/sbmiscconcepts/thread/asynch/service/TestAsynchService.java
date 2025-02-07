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

        testAsynchDao.testThreadAsynch();

        System.out.println("Service Thread Ends.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName() + " for flag => " + flag);
    }

    @Async("asyncExecutor")
    public String testAsynchFlowService(String flag){
        System.out.println("Service Thread Starts.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName() + " - " + flag);

        testAsynchDao.testAsynchFlowService(flag);

        System.out.println("Service Thread Ends.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName() + " - " + flag);

        return Thread.currentThread().getId() + " - " + Thread.currentThread().getName();

    }

    @Async("asyncExecutor")
    public CompletableFuture<String> testAsynchFlowServiceCompletable(String flag){
        System.out.println("Service Thread Starts.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName() + " - " + flag);

        testAsynchDao.testAsynchFlowService(flag);

        System.out.println("Service Thread Ends.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName() + " - " + flag);

       return CompletableFuture.completedFuture("Service Thread Ends.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName() + " - " + flag);

    }

    @Async("asyncExecutor")
    public String testAsynchFlowMultipleService1(){
        System.out.println("Service1 Thread Starts.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName());

        testAsynchDao.testAsynchFlowService(null);

        System.out.println("Service1 Thread Ends.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName());

        return Thread.currentThread().getId() + " - " + Thread.currentThread().getName();

    }

    @Async("asyncExecutor")
    public String testAsynchFlowMultipleService2(){
        System.out.println("Service2 Thread Starts.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName());

        testAsynchDao.testAsynchFlowService(null);

        System.out.println("Service2 Thread Ends.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName());

        return Thread.currentThread().getId() + " - " + Thread.currentThread().getName();

    }

    @Async("asyncExecutor")
    public CompletableFuture<String> testAsynchFlowServiceException(){
        System.out.println("ServiceException Thread Starts.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName());

        testAsynchDao.testAsynchFlowService(null);
        String s = null;
        s.length();

        System.out.println("ServiceException Thread Ends.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName());

        return CompletableFuture.completedFuture(Thread.currentThread().getId() + " - " + Thread.currentThread().getName());

    }
}

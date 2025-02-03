package com.subhajit.sbmiscconcepts.thread.synch.service;

import com.subhajit.sbmiscconcepts.thread.asynch.dao.TestAsynchDao;
import com.subhajit.sbmiscconcepts.thread.synch.dao.TestSynchDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class TestSynchService {

    @Autowired
    private TestSynchDao testSynchDao;

    public void testSynchFlowController(){
        System.out.println("Service Thread Starts.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName());

        testSynchDao.testSynchFlowController();

        System.out.println("Service Thread Ends.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName());

    }
    @Async("asyncExecutor")
    public CompletableFuture<String> testSynchFlowService(){
        System.out.println("Service Thread Starts.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName());

        testSynchDao.testSynchFlowService();

        System.out.println("Service Thread Ends.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName());

        return CompletableFuture.completedFuture(Thread.currentThread().getId() + " - " + Thread.currentThread().getName());

    }

    @Async("asyncExecutor")
    public CompletableFuture<String> testSynchFlowMultipleService1(){
        System.out.println("Service1 Thread Starts.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName());

        testSynchDao.testSynchFlowService();

        System.out.println("Service1 Thread Ends.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName());

        return CompletableFuture.completedFuture(Thread.currentThread().getId() + " - " + Thread.currentThread().getName());

    }

    @Async("asyncExecutor")
    public CompletableFuture<String> testSynchFlowMultipleService2(){
        System.out.println("Service2 Thread Starts.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName());

        testSynchDao.testSynchFlowService();

        System.out.println("Service2 Thread Ends.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName());

        return CompletableFuture.completedFuture(Thread.currentThread().getId() + " - " + Thread.currentThread().getName());

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
}

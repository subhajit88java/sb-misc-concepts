package com.subhajit.sbmiscconcepts.thread.synch.controller;

import com.subhajit.sbmiscconcepts.thread.asynch.service.TestAsynchService;
import com.subhajit.sbmiscconcepts.thread.synch.service.TestSynchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
public class TestSynchController {

    @Autowired
    private TestSynchService testSynchService;

    @GetMapping("/test-sync-flow-controller")
    @Async("asyncExecutor")
    public CompletableFuture<String> testSynchFlowController() {
        System.out.println("Controller Thread Starts.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName());

        testSynchService.testSynchFlowController();

        System.out.println("Controller Thread Ends.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName());

        return CompletableFuture.completedFuture(Thread.currentThread().getId() + " - " + Thread.currentThread().getName());

    }

    @GetMapping("/test-sync-flow-service")
    public CompletableFuture<String> testSynchFlowService() {
        System.out.println("Controller Thread Starts.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName());

        CompletableFuture<String> serviceOutput = testSynchService.testSynchFlowService();

        System.out.println("Controller Thread Ends.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName());

        CompletableFuture.allOf(serviceOutput);

        return serviceOutput;
    }

    @GetMapping("/test-sync-flow-multiple-service")
    public CompletableFuture<String> testSynchFlowMultipleService() {
        System.out.println("Controller Thread Starts.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName());

        CompletableFuture<String> serviceOutput1 = testSynchService.testSynchFlowMultipleService1();
        CompletableFuture<String> serviceOutput2 = testSynchService.testSynchFlowMultipleService2();

        System.out.println("Controller Thread Ends.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName());

        CompletableFuture.allOf(serviceOutput1, serviceOutput2).join();

        return CompletableFuture.completedFuture(serviceOutput1.getNow("serviceOutput1") + " - " + serviceOutput2.getNow("serviceOutput1"));
    }

    @GetMapping("/test-sync-flow-service-exception")
    public CompletableFuture<String> testSynchFlowServiceException() {
        System.out.println("Controller Thread Starts.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName());

        CompletableFuture<String> serviceOutput = testSynchService.testSynchFlowServiceException();

        System.out.println("Controller Thread Ends.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName());

        CompletableFuture.allOf(serviceOutput);

        return serviceOutput;
    }

}

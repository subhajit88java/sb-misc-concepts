package com.subhajit.sbmiscconcepts.thread.asynch.controller;

import com.subhajit.sbmiscconcepts.thread.asynch.service.TestAsynchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
public class TestAsynchController {

    @Autowired
    private TestAsynchService testAsynchService;

    @GetMapping("/test-thread-asynch/{flag}")
    @Async("asyncExecutor")
    public String testThreadAsynch(@PathVariable("flag") String flag) {
        System.out.println("Main Thread Starts.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName() + " - " + flag);

        testAsynchService.testThreadAsynch(flag);

        System.out.println("Main Thread Ends.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName() + " - " + flag);

        return "Thread id => " + Thread.currentThread().getId() + " | Thread name => " + Thread.currentThread().getName() + " completed!";
    }

    @GetMapping("/test-async-flow-controller")
    @Async("asyncExecutor")
    public CompletableFuture<String> testAsynchFlowController() {
        System.out.println("Controller Thread Starts.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName());

        testAsynchService.testAsynchFlowController();

        System.out.println("Controller Thread Ends.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName());

        return CompletableFuture.completedFuture(Thread.currentThread().getId() + " - " + Thread.currentThread().getName());

    }

    @GetMapping("/test-async-flow-service")
    public CompletableFuture<String> testAsynchFlowService() {
        System.out.println("Controller Thread Starts.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName());

        CompletableFuture<String> serviceOutput = testAsynchService.testAsynchFlowService();

        System.out.println("Controller Thread Ends.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName());

        CompletableFuture.allOf(serviceOutput);

        return serviceOutput;
    }

    @GetMapping("/test-async-flow-multiple-service")
    public CompletableFuture<String> testAsynchFlowMultipleService() {
        System.out.println("Controller Thread Starts.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName());

        CompletableFuture<String> serviceOutput1 = testAsynchService.testAsynchFlowMultipleService1();
        CompletableFuture<String> serviceOutput2 = testAsynchService.testAsynchFlowMultipleService2();

        System.out.println("Controller Thread Ends.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName());

        CompletableFuture.allOf(serviceOutput1, serviceOutput2).join();

        return CompletableFuture.completedFuture(serviceOutput1.getNow("serviceOutput1") + " - " + serviceOutput2.getNow("serviceOutput1"));
    }

    @GetMapping("/test-async-flow-service-exception")
    public CompletableFuture<String> testAsynchFlowServiceException() {
        System.out.println("Controller Thread Starts.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName());

        CompletableFuture<String> serviceOutput = testAsynchService.testAsynchFlowServiceException();

        System.out.println("Controller Thread Ends.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName());

        CompletableFuture.allOf(serviceOutput);

        return serviceOutput;
    }

}

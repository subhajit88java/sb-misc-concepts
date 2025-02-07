package com.subhajit.sbmiscconcepts.thread.asynch.controller;

import com.subhajit.sbmiscconcepts.thread.asynch.service.TestAsynchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> testThreadAsynch(@PathVariable("flag") String flag) {
        System.out.println("Main Thread Starts.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName() + " - " + flag);

        testAsynchService.testThreadAsynch(flag);

        System.out.println("Main Thread Ends.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName() + " - " + flag);

        return new ResponseEntity<>("Thread id => " + Thread.currentThread().getId() + " | Thread name => " + Thread.currentThread().getName() + " completed!", HttpStatus.OK);
    }

    @GetMapping("/test-async-flow-service/{flag}")
    public ResponseEntity<?> testAsynchFlowService(@PathVariable("flag") String flag) {
        System.out.println("Controller Thread Starts.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName() + " - " + flag);

        testAsynchService.testAsynchFlowService(flag);

        System.out.println("Controller Thread Ends.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName() + " - " + flag);

        return new ResponseEntity<>("Thread id => " + Thread.currentThread().getId() + " | Thread name => " + Thread.currentThread().getName() + " completed!", HttpStatus.OK);
    }

    @GetMapping("/test-async-flow-multiple-service")
    public ResponseEntity<?> testAsynchFlowMultipleService() {
        System.out.println("Controller Thread Starts.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName());

        String serviceOutput1 = testAsynchService.testAsynchFlowMultipleService1();
        String serviceOutput2 = testAsynchService.testAsynchFlowMultipleService2();

        System.out.println("Controller Thread Ends.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName());

       // CompletableFuture.allOf(serviceOutput1, serviceOutput2).join();

        return new ResponseEntity<>("Thread id => " + Thread.currentThread().getId() + " | Thread name => " + Thread.currentThread().getName() + " completed!", HttpStatus.OK);
    }

    @GetMapping("/test-thread-asynch-completable-one/{flag}")
    @Async("asyncExecutor")
    public CompletableFuture<?> testThreadAsynchCompletableOne(@PathVariable("flag") String flag) {
        System.out.println("Main Thread Starts.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName() + " - " + flag);

        testAsynchService.testThreadAsynch(flag);

        System.out.println("Main Thread Ends.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName() + " - " + flag);

        return  CompletableFuture.completedFuture("Main Thread Ends.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName() + " - " + flag);

        //return CompletableFuture.completedFuture(serviceOutput1.getNow("serviceOutput1") + " - " + serviceOutput2.getNow("serviceOutput1"));
    }

    @GetMapping("/test-async-flow-service-completable/{flag}")
    public CompletableFuture<?> testAsynchFlowServiceCompletable(@PathVariable("flag") String flag) {
        System.out.println("Controller Thread Starts.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName() + " - " + flag);

        CompletableFuture response = CompletableFuture.allOf(testAsynchService.testAsynchFlowServiceCompletable(flag));

        response.join();

        System.out.println("Controller Thread Ends.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName() + " - " + flag);

        return  response;
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

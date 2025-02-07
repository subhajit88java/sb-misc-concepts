package com.subhajit.sbmiscconcepts.thread.synch.controller;

import com.subhajit.sbmiscconcepts.thread.asynch.service.TestAsynchService;
import com.subhajit.sbmiscconcepts.thread.synch.service.TestSynchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
public class TestSynchController {

    @Autowired
    private TestSynchService testSynchService;

    @GetMapping("/test-sync-flow/{flag}")
    public ResponseEntity<?> testSynchFlow(@PathVariable("flag") String flag) {
        System.out.println("Controller Thread Starts.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName() + " for flag : " + flag);

        testSynchService.testSynchFlow(flag);

        System.out.println("Controller Thread Ends.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName() + " for flag : " + flag);

        return new ResponseEntity<>(" Thread Id : " + Thread.currentThread().getId() + " Thread Name : " + Thread.currentThread().getName() + " for flag : " + flag, HttpStatus.OK);

    }

    @GetMapping("/test-sync-flow-multiple-service")
    public  ResponseEntity<?> testSynchFlowMultipleService() {

        System.out.println("Controller Thread Starts.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName());

        String serviceOutput1 = testSynchService.testSynchFlowMultipleService1();
        String serviceOutput2 = testSynchService.testSynchFlowMultipleService2();

        System.out.println("Controller Thread Ends.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName());

        return new ResponseEntity<>(" Thread Id : " + Thread.currentThread().getId() + " Thread Name : " + Thread.currentThread().getName(), HttpStatus.OK);
    }

    @GetMapping("/test-thread-unsynch/{flag}/{monitor}")
    public String testThreadUnSynch(@PathVariable("flag") String flag, @PathVariable("monitor") String monitor) {
        System.out.println("Main Thread Starts.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName() + " - " + flag + " - " + monitor);

        testSynchService.testThreadUnSynch(flag, monitor);

        System.out.println("Main thread ends for flag : " + flag + " - " + monitor);

        return Thread.currentThread().getName() + " completed!";
    }

    @GetMapping("/test-thread-class-level-synch-block-one/{flag}/{monitor}")
    public String testThreadClassLvlSynchBlockOne(@PathVariable("flag") String flag, @PathVariable("monitor") String monitor) {
        System.out.println("Main Thread Starts.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName() + " - " + flag + " - " + monitor);

        testSynchService.testThreadClassLvlSynchBlockOne(flag, monitor);

        System.out.println("Main thread ends for flag : " + flag + " - " + monitor);

        return Thread.currentThread().getName() + " completed!";
    }

    @GetMapping("/test-thread-class-level-synch-block-two")
    public String testThreadClassLvlSynchBlockTwo() {
        System.out.println("Main Thread Starts.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName());

        testSynchService.testThreadClassLvlSynchBlockTwo();

        System.out.println("Main thread ends");

        return Thread.currentThread().getName() + " completed!";
    }

    @GetMapping("/test-thread-object-level-synch-block/{flag}/{monitor}")
    public String testThreadObjectLvlSynchBlock(@PathVariable("flag") String flag, @PathVariable("monitor") String monitor) {
        System.out.println("Main Thread Starts.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName() + " - " + flag + " - " + monitor);

        testSynchService.testThreadObjectLvlSynchBlock(flag, monitor);

        System.out.println("Main thread ends for flag : " + flag + " - " + monitor);

        return Thread.currentThread().getName() + " completed!";
    }

}

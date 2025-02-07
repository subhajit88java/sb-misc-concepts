package com.subhajit.sbmiscconcepts.thread.asynch.controller;

import com.subhajit.sbmiscconcepts.thread.asynch.service.TestReactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
public class TestReactController {

    @Autowired
    private TestReactService testReactService;

    @GetMapping("/test-thread-react-controller/{flag}")
    public ResponseEntity<Mono<String>> testThreadReactController(@PathVariable("flag") String flag) {
        System.out.println("Main Thread Starts.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName() + " - " + flag);

        Mono<String> response = Mono.just("Hello World").delayElement(Duration.ofSeconds(20L));

        System.out.println("Main Thread Ends.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName() + " - " + flag);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/test-thread-react-service/{flag}")
    public ResponseEntity<Mono<String>> testThreadReactService(@PathVariable("flag") String flag) {
        System.out.println("Main Thread Starts.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName() + " - " + flag);

        Mono<String> response = testReactService.testThreadReactService(flag);

        System.out.println("Main Thread Ends.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName() + " - " + flag);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/test-thread-react-web-client/{flag}")
    public ResponseEntity<Mono<String>> testThreadReactWebClient(@PathVariable("flag") String flag) {
        System.out.println("Main Thread Starts.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName() + " - " + flag);

        Mono<String> response = testReactService.testThreadReactWebClient(flag);

        System.out.println("Main Thread Ends.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName() + " - " + flag);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

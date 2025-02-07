package com.subhajit.sbmiscconcepts.thread.synch.dao;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Component
public class TestReactDao {
    public Mono<String> testThreadReactService(String flag) {
        System.out.println("Dao Thread Starts.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName() + " - " + flag);

        Mono<String> response = Mono
                .just("Hello World : " + flag)
                .delayElement(Duration.ofSeconds(20L));
       /* try{
            Thread.sleep(20000);
        }catch(Exception e){}*/


        System.out.println("Dao Thread Ends.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName() + " - " + flag);

        return response;
    }
}

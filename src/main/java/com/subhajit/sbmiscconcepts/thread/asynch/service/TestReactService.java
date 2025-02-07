package com.subhajit.sbmiscconcepts.thread.asynch.service;

import com.subhajit.sbmiscconcepts.thread.synch.dao.TestReactDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

@Service
public class TestReactService {

    @Autowired
    private TestReactDao testReactDao;

    public Mono<String> testThreadReactService(String flag) {
        System.out.println("Service Thread Starts.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName() + " - " + flag);

        Mono<String> response = testReactDao.testThreadReactService(flag);
        System.out.println("Service Thread Ends.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName() + " - " + flag);

        return response;
    }

    public Mono<String> testThreadReactWebClient(String flag) {
        System.out.println("Service Thread Starts.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName() + " - " + flag);

        WebClient webClient = WebClient.builder()
                .baseUrl("http://localhost:10000/spring-boot-input-output-storehouse")
                .build();

        Mono<String>  response = webClient
                .get()
                .uri("/read-timeout")
                .retrieve()
                .bodyToMono(String.class);

        System.out.println("Service Thread Ends.................." + " Thread Id : " + Thread.currentThread().getId()
                + " Thread Name : " + Thread.currentThread().getName() + " - " + flag);

        return response;
    }
}

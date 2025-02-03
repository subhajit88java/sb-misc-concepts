package com.subhajit.sbmiscconcepts.thread.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.subhajit.sbmiscconcepts.thread.service.ThreadService;

import java.util.concurrent.CompletableFuture;

@RestController
public class TestThreadController {
	
	@Autowired
	private ThreadService threadService;

	@GetMapping("/test-thread-synch/{flag}")
	public String testThreadSynch(@PathVariable("flag") String flag) {
		System.out.println("Main Thread Starts.................." + " Thread Id : " + Thread.currentThread().getId()
				+ " Thread Name : " + Thread.currentThread().getName() + " - " + flag);

		threadService.testThreadSynch(flag);

		System.out.println("Main thread ends for flag : " + flag);

		return "Thread id => " + Thread.currentThread().getId() + " | Thread name => " + Thread.currentThread().getName() + " completed!";
	}

	@GetMapping("/test-thread-unsynch/{flag}/{monitor}")
	public String testThreadUnSynch(@PathVariable("flag") String flag, @PathVariable("monitor") String monitor) {
		System.out.println("Main Thread Starts.................." + " Thread Id : " + Thread.currentThread().getId()
				+ " Thread Name : " + Thread.currentThread().getName() + " - " + flag + " - " + monitor);

		threadService.testThreadUnSynch(flag, monitor);

		System.out.println("Main thread ends for flag : " + flag + " - " + monitor);

		return Thread.currentThread().getName() + " completed!";
	}
	
	@GetMapping("/test-thread-class-level-synch-block-one/{flag}/{monitor}")
	public String testThreadClassLvlSynchBlockOne(@PathVariable("flag") String flag, @PathVariable("monitor") String monitor) {
		System.out.println("Main Thread Starts.................." + " Thread Id : " + Thread.currentThread().getId()
				+ " Thread Name : " + Thread.currentThread().getName() + " - " + flag + " - " + monitor);
		
		threadService.testThreadClassLvlSynchBlockOne(flag, monitor);
		
		System.out.println("Main thread ends for flag : " + flag + " - " + monitor);
		
		return Thread.currentThread().getName() + " completed!";
	}

	@GetMapping("/test-thread-class-level-synch-block-two")
	public String testThreadClassLvlSynchBlockTwo() {
		System.out.println("Main Thread Starts.................." + " Thread Id : " + Thread.currentThread().getId()
				+ " Thread Name : " + Thread.currentThread().getName());

		threadService.testThreadClassLvlSynchBlockTwo();

		System.out.println("Main thread ends");

		return Thread.currentThread().getName() + " completed!";
	}

	@GetMapping("/test-thread-object-level-synch-block/{flag}/{monitor}")
	public String testThreadObjectLvlSynchBlock(@PathVariable("flag") String flag, @PathVariable("monitor") String monitor) {
		System.out.println("Main Thread Starts.................." + " Thread Id : " + Thread.currentThread().getId()
				+ " Thread Name : " + Thread.currentThread().getName() + " - " + flag + " - " + monitor);

		threadService.testThreadObjectLvlSynchBlock(flag, monitor);

		System.out.println("Main thread ends for flag : " + flag + " - " + monitor);

		return Thread.currentThread().getName() + " completed!";
	}

	@GetMapping("/test-thread-flow")
	@Async
	public String testThreadFlow(String name) {
		System.out.println("Controller Thread Starts.................." + " Thread Id : " + Thread.currentThread().getId()
				+ " Thread Name : " + Thread.currentThread().getName());

		threadService.testThreadFlow();

		System.out.println("Controller Thread Ends.................." + " Thread Id : " + Thread.currentThread().getId()
				+ " Thread Name : " + Thread.currentThread().getName());

		return Thread.currentThread().getId() + " - " + Thread.currentThread().getName();
	}

}

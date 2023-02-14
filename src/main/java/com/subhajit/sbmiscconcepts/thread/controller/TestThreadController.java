package com.subhajit.sbmiscconcepts.thread.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.subhajit.sbmiscconcepts.thread.service.ThreadService;

@RestController
public class TestThreadController {
	
	@Autowired
	private ThreadService threadService;
	
	@GetMapping("/test-thread/{flag}/{monitor}")
	public String testThread(@PathVariable("flag") String flag, @PathVariable("monitor") String monitor) {
		System.out.println("Main Thread Starts.................." + " Thread Id : " + Thread.currentThread().getId()
				+ " Thread Name : " + Thread.currentThread().getName() + " - " + flag + " - " + monitor);
		
		threadService.testThreadService(flag, monitor);
		
		System.out.println("Main thread ends for flag : " + flag + " - " + monitor);
		
		return Thread.currentThread().getName() + " completed!";
	}

}

package com.subhajit.sbmiscconcepts.thread.service;

import org.springframework.stereotype.Component;

@Component
public class ThreadService {
		
	public void testThreadService(String flag, String monitor) {
		System.out.println("In service Flag : " + flag + " - " + System.identityHashCode(monitor));
		synchronized (monitor.getClass()) {
			System.out.println("Under synchronized block for flag ==> " + flag + " - " + monitor);
			try {
				Thread.sleep(20000);
			}catch(Exception e) {}
			System.out.println("Synchronized block ends for flag ==> " + flag + " - " + monitor);
		}
		
	}

}

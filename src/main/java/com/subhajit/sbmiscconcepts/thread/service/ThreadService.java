package com.subhajit.sbmiscconcepts.thread.service;

import com.subhajit.sbmiscconcepts.thread.api.ThreadApi;
import com.subhajit.sbmiscconcepts.thread.dao.ThreadDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ThreadService {

	@Autowired
	private ThreadDao threadDao;

	@Autowired
	private ThreadApi threadApi;
		
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

	public void testThreadFlow() {
		System.out.println("Service Thread Starts.................." + " Thread Id : " + Thread.currentThread().getId()
				+ " Thread Name : " + Thread.currentThread().getName());

		threadDao.testThreadFlow();
		threadApi.testThreadFlow();

		System.out.println("Service Thread Ends.................." + " Thread Id : " + Thread.currentThread().getId()
				+ " Thread Name : " + Thread.currentThread().getName());

	}

}

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

	public void testThreadSynch(String flag) {
		System.out.println("testThreadSynch starts for Flag : " + flag);
		try {
			Thread.sleep(5000);
		}catch(Exception e) {}
		System.out.println("testThreadSynch ends for flag ==> " + flag);
	}

	public void testThreadUnSynch(String flag, String monitor) {
		System.out.println("In service Flag : " + flag + " - " + System.identityHashCode(monitor));
			System.out.println("Usynchronized block starts for flag ==> " + flag + " - " + monitor);
			try {
				Thread.sleep(20000);
			}catch(Exception e) {}
			System.out.println("Usynchronized block ends for flag ==> " + flag + " - " + monitor);
	}
		
	public void testThreadClassLvlSynchBlockOne(String flag, String monitor) {
		System.out.println("In service Flag : " + flag + " - " + System.identityHashCode(monitor));
		synchronized (monitor.getClass()) {
			System.out.println("Class level synchronized block starts for flag ==> " + flag + " - " + monitor);
			try {
				Thread.sleep(20000);
			}catch(Exception e) {}
			System.out.println("Class level synchronized block ends for flag ==> " + flag + " - " + monitor);
		}
	}

	public void testThreadClassLvlSynchBlockTwo() {
		synchronized (String.class) {
			System.out.println("Class level synchronized block starts");
			try {
				Thread.sleep(20000);
			}catch(Exception e) {}
			System.out.println("Class level synchronized block ends");
		}
	}

	public void testThreadObjectLvlSynchBlock(String flag, String monitor) {
		System.out.println("In service Flag : " + flag + " - " + System.identityHashCode(monitor));
		synchronized (monitor) {
			System.out.println("Object level synchronized block starts for flag ==> " + flag + " - " + monitor);
			try {
				Thread.sleep(20000);
			}catch(Exception e) {}
			System.out.println("Object level synchronized block ends for flag ==> " + flag + " - " + monitor);
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

package com.example.multithreading.locks.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {

	private boolean isAvailable = false;
	ReentrantLock lock = new ReentrantLock();
	
	public void lockData() {
		try {
			lock.lock();
			System.out.println("Lock acquired by " + Thread.currentThread().getName());
			isAvailable = true;
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			System.out.println("Lock releases by " + Thread.currentThread().getName());
			isAvailable = false;
			lock.unlock();
		}
	}
	
}

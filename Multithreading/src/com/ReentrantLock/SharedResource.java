package com.ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {

	boolean isAvailable;
	
	public void producer(ReentrantLock lock) {
		try {
			lock.lock();
			System.out.println("Lock acquired by: " + Thread.currentThread().getName());
			isAvailable = true;
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			lock.unlock();
			System.out.println("Lock release by: " + Thread.currentThread().getName());
		}
	}
}

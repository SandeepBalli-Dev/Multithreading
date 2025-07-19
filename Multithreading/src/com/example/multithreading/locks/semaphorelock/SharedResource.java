package com.example.multithreading.locks.semaphorelock;

import java.util.concurrent.Semaphore;

public class SharedResource {

	boolean isAvailable = false;
	Semaphore lock = new Semaphore(2);

	public void producer() {
		try {
			lock.acquire();
			System.out.println("Lock acquired by " + Thread.currentThread().getName());
			isAvailable = true;
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			lock.release();
			System.out.println("Lock released by " + Thread.currentThread().getName());
		}
	}
}

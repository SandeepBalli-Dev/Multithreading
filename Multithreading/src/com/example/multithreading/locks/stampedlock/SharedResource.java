package com.example.multithreading.locks.stampedlock;

import java.util.concurrent.locks.StampedLock;

public class SharedResource {

	int a = 10;
	
	StampedLock lock = new StampedLock();
	
	public void produce() {
		long stamp = lock.tryOptimisticRead();
		try {
			System.out.println("Optimistic Read by " + Thread.currentThread().getName());
			a = 11;
			Thread.sleep(3000);
			if(lock.validate(stamp)) {
				System.out.println("Value updated by " + Thread.currentThread().getName());
			} else {
				a = 10;
				System.out.println("Roll Back in " + Thread.currentThread().getName());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void consume() {
		long stamp = lock.writeLock();
		System.out.println("Write Lock acquired by, "+ Thread.currentThread().getName());
		
		try {
			System.out.println("Updating value by " + Thread.currentThread().getName());
			a = 9;
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			lock.unlockWrite(stamp);
			System.out.println("Write Lock released by " + Thread.currentThread().getName());
		}
	}
}

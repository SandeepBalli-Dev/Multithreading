package com.example.multithreading.locks.readwritelock;

import java.util.concurrent.locks.ReadWriteLock;

public class SharedResource {

	private boolean isAvailable = false;
	
	public void consume(ReadWriteLock lock) {
		try {
			lock.readLock().lock();
			System.out.println("Read Lock acquired by " + Thread.currentThread().getName());
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			System.out.println("Read Lock released by " + Thread.currentThread().getName());
			lock.readLock().unlock();
		}
	}
	
	public void produce(ReadWriteLock lock) {
		try {
			lock.writeLock().lock();
			System.out.println("Write Lock acquired by " + Thread.currentThread().getName());
			isAvailable = true;
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			System.out.println("Write Lock released by " + Thread.currentThread().getName());
		}
	}
}

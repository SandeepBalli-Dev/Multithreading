package com.ReadWriteLock;

import java.util.concurrent.locks.ReadWriteLock;

public class SharedResource {

	boolean isAvailable = false;
	
	public void producer(ReadWriteLock lock) {
		lock.readLock().lock();
		System.out.println("Read lock acquired by, " + Thread.currentThread().getName());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			lock.readLock().unlock();
			System.out.println("Read lock released by, " + Thread.currentThread().getName());
		}
	}
	
	public void consumer(ReadWriteLock lock) {
		try {
			lock.writeLock().lock();
			System.out.println("Write lock acquired by, " + Thread.currentThread().getName());
			isAvailable = false;
		} catch (Exception e) {
			
		} finally {
			lock.writeLock().unlock();
			System.out.println("Write lock released by, " + Thread.currentThread().getName());
		}
		
	}
}

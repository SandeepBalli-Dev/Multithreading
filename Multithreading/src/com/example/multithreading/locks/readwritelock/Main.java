package com.example.multithreading.locks.readwritelock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Main {

	public static void main(String[] args) {
		SharedResource resource = new SharedResource();
		ReadWriteLock lock = new ReentrantReadWriteLock();

		Thread thread1 = new Thread(() -> resource.consume(lock));
		Thread thread2 = new Thread(() -> resource.consume(lock));
		Thread thread3 = new Thread(() -> resource.produce(lock));

		thread1.start();
		thread2.start();
		thread3.start();
	}
}

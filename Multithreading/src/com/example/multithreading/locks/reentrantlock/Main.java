package com.example.multithreading.locks.reentrantlock;

public class Main {

	public static void main(String[] args) {
		
		SharedResource resource = new SharedResource();
		
		Thread thread1 = new Thread(() -> resource.lockData());
		Thread thread2 = new Thread(() -> resource.lockData());
		
		thread1.start();
		thread2.start();
	}
}

package com.example.multithreading.monitor.lock.example;

public class MonitorLockExample {

	public synchronized void task1() {
		try {
			System.out.println("Task - 1. Before Timer");
			Thread.sleep(1000);
			System.out.println("Task - 1. After Timer");
		} catch (Exception e) {

		}
	}
	
	public void task2() {
		System.out.println("Task - 2. Before Synchronized Block");
		synchronized (this) {
			System.out.println("Task - 2. Inside Synchronized Block");
		}
	}
	
	public void task3() {
		System.out.println("Task - 3. No Synchronization");
	}
}

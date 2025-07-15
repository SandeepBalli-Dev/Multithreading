package com.example.multithreading.monitor.lock.example;

public class Main {

	public static void main(String[] args) {
		MonitorLockExample obj = new MonitorLockExample();

		Thread th1 = new Thread(() -> obj.task1());
		Thread th2 = new Thread(() -> obj.task2());
		Thread th3 = new Thread(() -> obj.task3());

		th1.start();
		th2.start();
		th3.start();
	}
}

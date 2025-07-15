package com.example.multithreading.interthread.communication;

public class SharedResource {

	public boolean isAvailable = false;

	public synchronized void addItem() {
		isAvailable = true;
		System.out.println("Item added by " + Thread.currentThread().getName());
		notifyAll();
	}

	public synchronized void consumeItem() {
		System.out.println(Thread.currentThread().getName() + " is trying to consume item");

		while (!isAvailable) {
			try {
				System.out.println(Thread.currentThread().getName() + " is waiting for item");
				wait();
			} catch (Exception e) {

			}
		}

		System.out.println(Thread.currentThread().getName() + " has consumed the item");
		isAvailable = false;
	}

}

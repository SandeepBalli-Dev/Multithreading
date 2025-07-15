package com.example.multithreading.interthread.communication;

public class Producer implements Runnable {

	SharedResource sharedResource;

	public Producer(SharedResource resource) {
		this.sharedResource = resource;
	}

	@Override
	public void run() {
		System.out.println("Producer Thread " + Thread.currentThread().getName());
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
		}
		sharedResource.addItem();
	}

}

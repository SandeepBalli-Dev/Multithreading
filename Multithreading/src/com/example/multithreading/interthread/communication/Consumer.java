package com.example.multithreading.interthread.communication;

public class Consumer implements Runnable {
	
	SharedResource sharedResource;
	
	public Consumer(SharedResource resource) {
		this.sharedResource = resource;
	}

	@Override
	public void run() {
		System.out.println("Consumer Thread " + Thread.currentThread().getName());
		sharedResource.consumeItem();
	}

}

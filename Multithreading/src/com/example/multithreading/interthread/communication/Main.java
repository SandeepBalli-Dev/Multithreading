package com.example.multithreading.interthread.communication;

public class Main {

	public static void main(String[] args) {
		SharedResource resource = new SharedResource();
		
//		Thread producerThread = new Thread(() -> resource.addItem());
//		Thread consumerThread = new Thread(() -> resource.consumeItem());
//		
//		producerThread.start();
//		consumerThread.start();
		
		Producer producer = new Producer(resource);
		Consumer consumer = new Consumer(resource);
		
		Thread producerThread = new Thread(producer);
		Thread consumerThread = new Thread(consumer);
		
		producerThread.start();
		consumerThread.start();
	}
}

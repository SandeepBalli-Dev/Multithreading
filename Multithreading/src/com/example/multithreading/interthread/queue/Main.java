package com.example.multithreading.interthread.queue;

public class Main {

	public static void main(String[] args) {
		SharedResource resource = new SharedResource(4);

		Thread producerThread = new Thread(() -> {

			for (int i = 1; i <= 8; i++) {
				resource.addItem(i);
			}
		});

		Thread consumerThread = new Thread(() -> {

			for (int i = 1; i < 8; i++) {
				resource.consumeItem();
			}
		});

		producerThread.start();
		consumerThread.start();
	}
}

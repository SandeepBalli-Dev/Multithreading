package com.sharedResource;

public class ProducerConsumer {

	public static void main(String[] args) {

		SharedResource sharedBuffer = new SharedResource(3);

		Thread producerThread = new Thread(() -> {
			for (int item = 1; item <= 6; item++) {
				try {
					sharedBuffer.produce(item);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		Thread consumerThread = new Thread(() -> {
			for (int item = 1; item <= 6; item++) {
				try {
					sharedBuffer.consume();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		producerThread.start();
		consumerThread.start();
	}
}

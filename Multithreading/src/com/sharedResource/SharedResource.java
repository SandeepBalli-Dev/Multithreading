package com.sharedResource;

import java.util.LinkedList;
import java.util.Queue;

public class SharedResource {

	private Queue<Integer> sharedBuffer;
	private int bufferSize;

	public SharedResource(int bufferSize) {
		sharedBuffer = new LinkedList<>();
		this.bufferSize = bufferSize;
	}

	public synchronized void produce(int item) throws InterruptedException {

		while (sharedBuffer.size() == bufferSize) {
			System.out.println("Buffer is full, Producer is waiting for consumer.");
			wait();
		}

		sharedBuffer.add(item);
		System.out.println("Produced new item, " + item);
		notifyAll();
	}

	public synchronized void consume() throws Exception {
		
		while(sharedBuffer.isEmpty()) {
			System.out.println("Buffer is empty, Consumer is waiting for producer.");
			wait();
		}
		
		int item = sharedBuffer.poll();
		System.out.println("Consumed item, " + item);
		notifyAll();
	}
}

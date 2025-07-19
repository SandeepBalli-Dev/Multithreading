package com.example.multithreading.interthread.queue;

import java.util.LinkedList;
import java.util.Queue;

public class SharedResource {

	private Queue<Integer> sharedBuffer;
	private int bufferSize;

	public SharedResource(int bufferSize) {
		sharedBuffer = new LinkedList<>();
		this.bufferSize = bufferSize;
	}

	public synchronized void addItem(int item) {

		while (sharedBuffer.size() == bufferSize) {
			try {
				System.out.println("Buffer is full.");
				wait();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		sharedBuffer.add(item);
		System.out.println("Item added to buffer");
		notify();
	}

	public synchronized int consumeItem() {
		while (sharedBuffer.isEmpty()) {
			try {
				System.out.println("Buffer is empty.");
				wait();
			} catch (Exception e) {

			}
		}

		int item = sharedBuffer.poll();
		System.out.println("Consumed item, " + item);
		notify();
		return item;

	}
}

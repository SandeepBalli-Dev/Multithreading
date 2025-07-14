package multithreading.Assignments._6;

import java.util.LinkedList;

public class ProducerConsumer {

	private final int capacity = 5;
	private final LinkedList<Integer> buffer = new LinkedList<>();

	public synchronized void produce(int value) throws InterruptedException {
		while (buffer.size() == capacity) {
			wait();
		}
		buffer.add(value);
		System.out.println("Produced value, " + value);
		notify();
	}

	public synchronized int consume() throws InterruptedException {
		while (buffer.isEmpty()) {
			wait();
		}
		int val = buffer.removeFirst();
		System.out.println("Consumed value, " + val);
		notify();
		return val;
	}

	public void implementProducerAndConsumer() throws InterruptedException {
		Thread producer = new Thread(() -> {
			for (int i = 1; i <= 10; i++) {
				try {
					produce(i);
					Thread.sleep(100);
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}

			}
		});

		Thread consumer = new Thread(() -> {
			for (int i = 1; i <= 10; i++) {
				try {
					consume();
					Thread.sleep(100);
				} catch (Exception e) {
					Thread.currentThread().interrupt();
				}
			}
		});

		producer.start();
		consumer.start();
	}
}

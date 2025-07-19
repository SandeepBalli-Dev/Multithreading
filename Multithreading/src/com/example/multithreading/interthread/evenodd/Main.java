package com.example.multithreading.interthread.evenodd;

public class Main {

	public static void main(String[] args) {
		SharedResource resource = new SharedResource();

		Thread oddThread = new Thread(() -> {
			for (int i = 1; i <= 19; i += 2) {
				resource.printOddNumber(i);
			}
		});

		Thread evenThread = new Thread(() -> {
			for (int i = 2; i <= 20; i += 2) {
				resource.printEvenNumber(i);
			}
		});

		oddThread.start();
		evenThread.start();
	}
}

package com.example.multithreading.interthread.evenodd;

public class SharedResource {

	boolean isAvailable = false;

	public synchronized void printOddNumber(int i) {

		try {
			while (isAvailable) {
				wait();
			}
			System.out.println("Odd - " + i);
			Thread.sleep(2000);
			isAvailable = true;
			notifyAll();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public synchronized void printEvenNumber(int i) {

		try {
			while (!isAvailable) {
				wait();
			}
			System.out.println("Even - " + i);
			isAvailable = false;
			notifyAll();

		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}

package com.example.multithreading.threads.lifecycle;

public class RunnableThread implements Runnable {

	@Override
	public void run() {
		System.out.println("Runnable thread running in thread, " + Thread.currentThread().getName());
	}

}

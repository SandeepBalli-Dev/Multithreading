package com.example.multithreading.threads.lifecycle;

public class Main {

	public static void main(String[] args) {

		MyThread thread = new MyThread();
		thread.start();
		thread.sayHello();
		
		Thread runnableThread = new Thread(new RunnableThread());
		runnableThread.start();
	}
}

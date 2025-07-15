package com.example.multithreading.threads.lifecycle;

public class MyThread extends Thread {

	public void run() {
		System.out.println("Running in thread, " + Thread.currentThread().getName());
	}

	public void sayHello() {
		System.out.println("Hello!");
	}

}

package com.example.multithreading.thread.local;

public class Main {

	public static void main(String[] args) {
		
		ThreadLocal<String> threadLocal = new ThreadLocal<>();
		threadLocal.set("First");
		
		Thread t1 = new Thread(() -> {
			threadLocal.set("Second");
		});
		
		t1.start();
		
		System.out.println(threadLocal.get());
	}
}

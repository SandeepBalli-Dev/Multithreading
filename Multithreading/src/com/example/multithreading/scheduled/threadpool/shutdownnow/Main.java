package com.example.multithreading.scheduled.threadpool.shutdownnow;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	public static void main(String[] args) {
		
		ExecutorService service = Executors.newFixedThreadPool(5);
		
		service.submit(() -> {
			
			try {
				Thread.sleep(5000);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			System.out.println("Task completed");
		});
		
		service.shutdownNow();
		System.out.println("Executing in main thread");
	}
}

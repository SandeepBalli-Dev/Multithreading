package com.example.multithreading.scheduled.threadpool.awaittermination;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {
		
		ExecutorService service = Executors.newFixedThreadPool(5);
		
		service.submit(() -> {
			
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			System.out.println("Task completed");
		});
		
		service.shutdown();
		
		try {
			boolean isTerminated = service.awaitTermination(3, TimeUnit.SECONDS);
			System.out.println("Is terminated - " + isTerminated);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		

		System.out.println("Executing in main thread");
	}
}

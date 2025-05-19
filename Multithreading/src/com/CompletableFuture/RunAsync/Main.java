package com.CompletableFuture.RunAsync;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			System.out.println("RunAsync is being executed..");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Task completed");
		}, executorService);
		
		future.join();
		executorService.shutdown();
	}
}

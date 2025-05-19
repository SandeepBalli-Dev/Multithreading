package com.CompletableFuture.ThenAccept;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
			System.out.println("Then Accept is being executed");
			return "Sandeep Balli";
		}, executorService).thenAccept((name) -> {
			System.out.println( name.toUpperCase() + " is 25 years old");
		});
		
		future.join();
		executorService.shutdown();
	}
}

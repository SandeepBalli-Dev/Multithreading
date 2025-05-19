package com.CompletableFuture.ThenApply;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
			System.out.println("Then Apply is being executed");
			return "Sandeep Balli";
		}, executorService).thenApply((name) -> {
			return name.toUpperCase() + " is 25 years old";
		});
		
		System.out.println("Future content - " + future.join());
		executorService.shutdown();
	}
}

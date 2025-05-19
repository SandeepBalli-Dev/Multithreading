package com.CompletableFuture.ThenCombine;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	static ExecutorService executorService = Executors.newFixedThreadPool(2);
	
	public static void main(String[] args) {
		CompletableFuture<String> firstNameFuture = CompletableFuture.supplyAsync(() -> {
			System.out.println("Executing First name future on thread, " + Thread.currentThread().getName());
			sleep(1000);
			return "Sandeep";
		}, executorService);
		
		CompletableFuture<String> secondNameFuture = CompletableFuture.supplyAsync(() -> {
			System.out.println("Executing Second name future on thread, " + Thread.currentThread().getName());
			sleep(1000);
			return " Balli";
		}, executorService);
		
		CompletableFuture<String> fullNameFuture = firstNameFuture.thenCombine(secondNameFuture, (firstName, secondName) -> {
			System.out.println("Executing Full name future on thread, " + Thread.currentThread().getName());
			return firstName + secondName;
		});
		
		String fullName = fullNameFuture.join();
		System.out.println("Full Name, " + fullName);
			
		executorService.shutdown();
	}
	
	 static void sleep(long ms) {
	        try { Thread.sleep(ms); } catch (InterruptedException ignored) {}
	    }
}

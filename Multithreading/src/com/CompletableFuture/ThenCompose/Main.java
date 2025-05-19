package com.CompletableFuture.ThenCompose;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	static ExecutorService executorService = Executors.newFixedThreadPool(2);

	public static void main(String[] args) {
		CompletableFuture<String> future = getUserId().thenCompose(userId -> getUseName(userId));

		String result = future.join();
		System.out.println("Final Result: " + result);

		executorService.shutdown();
	}

	public static CompletableFuture<Integer> getUserId() {
		return CompletableFuture.supplyAsync(() -> {
			System.out.println("Fetching user id on, " + Thread.currentThread().getName());
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return 35;
		}, executorService);
	}

	public static CompletableFuture<String> getUseName(Integer userId) {
		return CompletableFuture.supplyAsync(() -> {
			System.out.println("Fetching user name on, " + Thread.currentThread().getName());
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return "USER_" + userId;
		}, executorService);
	}
}

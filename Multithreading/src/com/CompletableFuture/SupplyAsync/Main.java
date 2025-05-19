package com.CompletableFuture.SupplyAsync;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
			System.out.println("Supply async is being executed");
			Integer sum = calculateSum(5);calculateSum(5);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return sum;
		}, executorService);

		System.out.println("Supply async thread returned value, " + future.join());

		future.join();
		executorService.shutdown();
	}

	public static Integer calculateSum(Integer value) {
		Integer sum = 0;
		for (int i = 1; i <= value; i++) {
			sum += i;
		}
		return sum;
	}
}

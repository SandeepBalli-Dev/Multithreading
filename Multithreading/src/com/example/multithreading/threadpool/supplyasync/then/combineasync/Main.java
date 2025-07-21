package com.example.multithreading.threadpool.supplyasync.then.combineasync;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {

		ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 5, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10),
				Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

		CompletableFuture<String> firstNameFuture = CompletableFuture.supplyAsync(() -> {
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "Sandeep";
		}, executor);

		CompletableFuture<String> lastNameFuture = CompletableFuture.supplyAsync(() -> {
			return " Balli ";
		}, executor);

		CompletableFuture<String> fullNameFuture = firstNameFuture.thenCombine(lastNameFuture,
				(String firstName, String lastName) -> {
					return firstName + lastName;
				});

		try {
			System.out.println(fullNameFuture.get());
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}

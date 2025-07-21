package com.example.multithreading.threadpool.supplyasync.then.applyasync;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {

		try {
			ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 5, 10, TimeUnit.SECONDS,
					new ArrayBlockingQueue<>(10), Executors.defaultThreadFactory(),
					new ThreadPoolExecutor.AbortPolicy());

			CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {

				try {
					Thread.sleep(3000);
				} catch (Exception e) {

				}
				System.out.println("Thread - " + Thread.currentThread().getName());
				return "Executing Supply async";
			}, executor).thenApplyAsync((String val) -> {
				System.out.println("Thread - " + Thread.currentThread().getName());
				return val + " with then apply async";
			}, executor);

			System.out.println(future.get());
		} catch (Exception e) {

		}

	}
}
package com.example.multithreading.threadpool.supplyasync.then.apply;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {

		try {
			ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 2, 10, TimeUnit.SECONDS,
					new ArrayBlockingQueue<>(10), Executors.defaultThreadFactory(),
					new ThreadPoolExecutor.AbortPolicy());

			CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
				System.out.println("Thread - " + Thread.currentThread().getName());
				return "Executing Supply async";
			}, executor).thenApply((String val) -> {
				System.out.println("Thread - " + Thread.currentThread().getName());
				return val + " with then apply";
			});

			System.out.println(future.get());
		} catch (Exception e) {

		}

	}
}

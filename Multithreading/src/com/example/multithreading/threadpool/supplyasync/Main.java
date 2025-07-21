package com.example.multithreading.threadpool.supplyasync;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {

		try {
			ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 2, 4, TimeUnit.SECONDS,
					new ArrayBlockingQueue<>(10), Executors.defaultThreadFactory(),
					new ThreadPoolExecutor.AbortPolicy());

			CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
				return "Executing supply async";
			}, executor);

			System.out.println(future.get());
		} catch (Exception e) {

		}

	}
}

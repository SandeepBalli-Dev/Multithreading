package com.example.multithreading.threadpool.supplyasync.then.compose;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {

		ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 5, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10),
				Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

		CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
			return "Executing Supply async with";
		}, executor).thenCompose((String val) -> {
			return CompletableFuture.supplyAsync(() -> val + " with then compose");
		});

		try {
			System.out.println(future.get());
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}
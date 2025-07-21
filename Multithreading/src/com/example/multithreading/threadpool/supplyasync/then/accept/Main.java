package com.example.multithreading.threadpool.supplyasync.then.accept;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {

		ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 5, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10),
				Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

		CompletableFuture<?> future = CompletableFuture.supplyAsync(() -> {
			return "Executing Supply Async";
		}, executor).thenAccept((String val) -> {
			System.out.println("Then accept does not return anything. So Converting the text to Upper case - "
					+ val.toUpperCase());
		});
		
		try {
			future.get();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}

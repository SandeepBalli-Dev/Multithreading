package com.example.multithreading.threadpool.supplyasync.then.acceptasync;

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
		}, executor).thenAcceptAsync((String val) -> {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Then accept does not return anything. So Converting the text to Upper case - "
					+ val.toUpperCase());
		}, executor).thenRunAsync(() -> {
			System.out.println("I am of no use");
		});

		try {
			future.get();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}

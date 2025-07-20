package com.example.multithreading.threadpool.future;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Main {

	public static void main(String[] args) {

		ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 1, TimeUnit.HOURS, new ArrayBlockingQueue<>(10),
				Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

		Future<?> future = executor.submit(() -> {

			try {
				Thread.sleep(7000);
			} catch (Exception e) {

			}
		});

		System.out.println("Is Done: " + future.isDone());
		
		try {
			future.get(2, TimeUnit.SECONDS);
		} catch (TimeoutException te) {
			System.out.println("Timeout Exception");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			future.get();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		System.out.println("Is Done: " + future.isDone());
		System.out.println("Is Cancelled: " + future.isCancelled());
	}
}

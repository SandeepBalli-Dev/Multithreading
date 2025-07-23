package com.example.multithreading.scheduled.threadpool.schedule;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {

		ScheduledExecutorService service = Executors.newScheduledThreadPool(5);

		Future<?> runnableFuture = service.schedule(() -> {
			System.out.println("Runnable task executed in scheduled thread pool");
		}, 2, TimeUnit.SECONDS);

		Future<String> callableFuture = service.schedule(() -> {
			return "Callable task executed in scheduled thread pool";
		}, 3, TimeUnit.SECONDS);
		
		Future<?> runnableFixedRateFuture = service.scheduleAtFixedRate(() -> {
			System.out.println("Executing in scheduled fixed rate at every 2 seconds - " + new Date());
		}, 1, 2, TimeUnit.SECONDS);

		try {
			runnableFuture.get();
			System.out.println(callableFuture.get());
			runnableFixedRateFuture.get();
		} catch (Exception e) {

		}
		
		runnableFixedRateFuture.cancel(true);

	}
}

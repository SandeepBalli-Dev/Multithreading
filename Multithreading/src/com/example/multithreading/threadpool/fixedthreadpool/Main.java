package com.example.multithreading.threadpool.fixedthreadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

	public static void main(String[] args) {
		ExecutorService service = Executors.newFixedThreadPool(5);

		try {
			Future<String> future1 = service.submit(() -> "Running in async mode - 1");
			Future<String> future2 = service.submit(() -> "Running in async mode - 2");
			Future<String> future3 = service.submit(() -> "Running in async mode - 3");

			System.out.println(future1.get());
			System.out.println(future2.get());
			System.out.println(future3.get());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

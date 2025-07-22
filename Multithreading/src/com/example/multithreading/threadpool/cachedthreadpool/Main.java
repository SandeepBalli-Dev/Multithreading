package com.example.multithreading.threadpool.cachedthreadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

	public static void main(String[] args) {

		ExecutorService service = Executors.newCachedThreadPool();
		Future<String> future = service.submit(() -> "Running in cached thread pool");
		
		try {
			System.out.println(future.get());
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}

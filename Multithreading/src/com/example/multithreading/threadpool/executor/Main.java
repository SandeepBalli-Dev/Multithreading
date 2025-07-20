package com.example.multithreading.threadpool.executor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {

//		ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 4, 10, TimeUnit.MINUTES, new ArrayBlockingQueue<>(2),
//				Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardOldestPolicy());

		ThreadPoolExecutor customExecutor = new ThreadPoolExecutor(2, 4, 10, TimeUnit.MINUTES,
				new ArrayBlockingQueue<>(2), new CustomThreadFactory(), new CustomRejectionHandler());

		customExecutor.allowCoreThreadTimeOut(true);
		for (int i = 1; i <= 7; i++) {
			customExecutor.submit(() -> {

				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					// TODO: handle exception
				}
				System.out.println("Task processed by, " + Thread.currentThread().getName());
			});
		}
		customExecutor.shutdown();
	}

}

class CustomThreadFactory implements ThreadFactory {

	@Override
	public Thread newThread(Runnable r) {
		Thread thread = new Thread(r);
		thread.setPriority(Thread.NORM_PRIORITY);
		thread.setDaemon(false);
		return thread;
	}
}

class CustomRejectionHandler implements RejectedExecutionHandler {

	@Override
	public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
		System.out.println("Task rejected " + r.toString());

	}

}

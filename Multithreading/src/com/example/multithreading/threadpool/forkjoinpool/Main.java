package com.example.multithreading.threadpool.forkjoinpool;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

public class Main {

	public static void main(String[] args) {

		ForkJoinPool pool = ForkJoinPool.commonPool();
		Future<Integer> future = pool.submit(new ComputeTask(0, 100));

		try {
			Integer sum = future.get();
			System.out.println("Sum: " + sum);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}

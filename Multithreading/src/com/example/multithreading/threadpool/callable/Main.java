package com.example.multithreading.threadpool.callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {

		ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 1, TimeUnit.HOURS, new ArrayBlockingQueue<>(10),
				Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

		List<Integer> outputList = new ArrayList<>();
		Future<List<Integer>> future = executor.submit(() -> {
			for (int i = 1; i <= 10; i++) {
				outputList.add(i);
			}
		}, outputList);

		try {
			future.get();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		System.out.print("External List - ");
		outputList.forEach(i -> System.out.print(i + " "));

		// Other way
		Future<List<Integer>> callableFuture = executor.submit(() -> {
			List<Integer> list = new ArrayList<>();
			for (int i = 1; i <= 10; i++) {
				list.add(i);
			}
			return list;
		});
		
		System.out.println();
		System.out.print("Internal List - ");
		try {
			List<Integer> list = callableFuture.get();
			list.forEach(i -> System.out.print(i + " "));
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}

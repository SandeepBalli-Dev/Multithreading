package com.example.multithreading.threadpool.supplyasync.then.composeasync;

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
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				// TODO: handle exception
			}
			System.out.println("Top 1 - " + Thread.currentThread().getName());
			return "Executing supply async";
		}, executor).thenComposeAsync((String val) -> {
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				// TODO: handle exception
			}
			System.out.println("Top 2 - " + Thread.currentThread().getName());
			return CompletableFuture.supplyAsync(() -> val + " with then compose async 1");
		}, executor).thenComposeAsync((String val) -> {
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				// TODO: handle exception
			}
			System.out.println("Top 3 - " + Thread.currentThread().getName());
			return CompletableFuture.supplyAsync(() -> val + " With then compose async 2");
		}, executor);

		try {
			System.out.println(future.get());
		} catch (Exception e) {

		}

	}
}

package multithreading.Assignments._7;

import java.util.concurrent.Executors;

public class Main {

	public static void main(String[] args) throws InterruptedException {
//		System.out.println("Implementing Thread Pool Executor");
//		ThreadPool pool = new ThreadPool();
//		pool.implementThreadPoolTask();
		
		System.out.println("Performance of Fixed and Cached Thread Pool");
		ThreadPerformance threadPerformance = new ThreadPerformance();
		System.out.println("Fixed Thread Pool");
		threadPerformance.implementThreadPoolPerformance(Executors.newFixedThreadPool(10));
		System.out.println("Cached Thread Pool");
		threadPerformance.implementThreadPoolPerformance(Executors.newCachedThreadPool());
		
	}
}

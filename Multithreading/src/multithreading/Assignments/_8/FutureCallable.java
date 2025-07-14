package multithreading.Assignments._8;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureCallable {

	public void implementSquareOfANumber() {
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		
		List<Future<Integer>> futures = new ArrayList<>();
		
		for(int i = 1; i <= 5; i++) {
			int number = i;
			Callable<Integer> task = () -> {
				Thread.sleep(500);
				return number * number;
			};
			Future<Integer> future = executorService.submit(task);
			futures.add(future);
		}
		
		for(int i = 0; i< futures.size(); i++) {
			try {
				Integer result = futures.get(i).get();
				System.out.println("Sqaure of " + (i + 1) + " is " + result);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		executorService.shutdown();
	}
}

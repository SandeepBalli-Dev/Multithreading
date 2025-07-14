package multithreading.Assignments._8;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Timeout {

	public void implementTimeout() {
		ExecutorService executorService = Executors.newSingleThreadExecutor();

		Callable<Integer> longRunningtask = () -> {
			Thread.sleep(3000);
			return 999;
		};

		Future<Integer> future = executorService.submit(longRunningtask);

		try {
			Integer result = future.get(1, TimeUnit.SECONDS);
			System.out.println("Result: " + result);
		} catch (TimeoutException e) {
			System.out.println("Timeout! Task took too long.");
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		} finally {
			executorService.shutdownNow();
		}
	}
}

package multithreading.Assignments._7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {

	public void implementThreadPoolTask() {
		ExecutorService executorService = Executors.newFixedThreadPool(3);

		for (int i = 1; i <= 10; i++) {
			int taskId = i;
			executorService.submit(() -> {
				System.out.println("Task - " + taskId + " executed by " + Thread.currentThread().getName());
				try {
					Thread.sleep(500);
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
		}
		executorService.shutdown();
	}
}

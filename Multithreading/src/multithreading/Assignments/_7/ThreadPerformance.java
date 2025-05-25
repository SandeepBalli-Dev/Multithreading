package multithreading.Assignments._7;

import java.util.concurrent.ExecutorService;

public class ThreadPerformance {

	public void implementThreadPoolPerformance(ExecutorService service) throws InterruptedException {
		long start = System.currentTimeMillis();

		for (int i = 1; i <= 100; i++) {
			int taskId = i;
			service.submit(() -> {
				System.out.println("Task - " + taskId + " executed by " + Thread.currentThread().getName());
				try {
					Thread.sleep(500);
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
		}
		service.shutdown();
		while (!service.isTerminated()) {
			Thread.sleep(50);
		}

		long end = System.currentTimeMillis();
		System.out.println("Time taken: " + (end - start) + " ms");

	}
}

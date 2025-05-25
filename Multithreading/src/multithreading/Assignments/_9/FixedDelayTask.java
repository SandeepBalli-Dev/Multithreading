package multithreading.Assignments._9;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class FixedDelayTask {

	public void implementFixedDelayTask() {
		ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
		Runnable task = () -> {
			System.out.println("Start task at, " + System.currentTimeMillis());
		};
		
		executorService.scheduleWithFixedDelay(task, 0, 2, TimeUnit.SECONDS);
		executorService.schedule(() -> {
			System.out.println("Shutting down!!");
			executorService.shutdown();
		}, 10, TimeUnit.SECONDS);
	}
}

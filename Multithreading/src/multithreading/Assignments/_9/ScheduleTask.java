package multithreading.Assignments._9;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleTask {

	public void implementScheduleTask() {
		ScheduledExecutorService scheduleTask = Executors.newScheduledThreadPool(1);
		Runnable task = () -> {
			System.out.println("Running task after 5 seconds");
		};

		System.out.println("Scheduling Task");
		scheduleTask.schedule(task, 5, TimeUnit.SECONDS);

		scheduleTask.shutdown();
	}
}

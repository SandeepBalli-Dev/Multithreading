package multithreading.Assignments._9;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class FixedRateTask {

	public void impementScheduleTaskAtFixedRate() {
		ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
		Runnable heartBeat = () -> {
			System.out.println("HeartBeat: " + System.currentTimeMillis());
		};
		
		executorService.scheduleAtFixedRate(heartBeat, 0, 2, TimeUnit.SECONDS);
		executorService.schedule(() -> {
			System.out.println("Shutting down!!");
			executorService.shutdown();
		}, 10, TimeUnit.SECONDS);
	}
}

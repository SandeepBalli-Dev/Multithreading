package multithreading.Assignments._3;

import java.util.Date;

public class DaemonThread {

	public void implementDaemonThread() {
		
		Thread daemonThread = new Thread(() -> {
			
			while(true) {
				System.out.println("Current Time - " + new Date());
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		daemonThread.setDaemon(true);
		daemonThread.start();
		
		System.out.println("Main thread is sleepig for 5 seconds");
		
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Main thread finished");
	}
}

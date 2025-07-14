package multithreading.Assignments._2;

public class ThreadLifeCycle {

	private Object lock = new Object();

	public void implementLifeCycle() {

		Thread sleepingThread = new Thread(() -> {
			try {
				Thread.sleep(3000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}, "Sleeping Thread");

		Thread blockedThread = new Thread(() -> {
			synchronized (lock) {
				try {
					Thread.sleep(5000);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}, "Blocked Thread");

		Thread waitingThread = new Thread(() -> {
			try {
				sleepingThread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}, "Waiting Thread");

		System.out.println("Before starting -> SleepingThread state: " + sleepingThread.getState()); // NEW

		sleepingThread.start();
		blockedThread.start();
		waitingThread.start();

		new Thread(() -> {
			synchronized (lock) {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "LockHolder").start();

		System.out.println("SleepingThread state: " + sleepingThread.getState()); // TIMED_WAITING or TERMINATED
		System.out.println("BlockedThread state: " + blockedThread.getState()); // BLOCKED or RUNNABLE
		System.out.println("WaitingThread state: " + waitingThread.getState()); // WAITING
	}
}

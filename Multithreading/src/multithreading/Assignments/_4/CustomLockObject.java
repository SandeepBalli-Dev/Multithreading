package multithreading.Assignments._4;

public class CustomLockObject {

	private Integer counter = 0;
	private final Object lock = new Object();

	public void increment() {
		synchronized (lock) {
			counter++;
		}
	}

	public void implementCustomLockObject() {

		Runnable task = () -> {
			for (int i = 0; i < 1000; i++) {
				increment();
			}
		};

		Thread thread1 = new Thread(task);
		Thread thread2 = new Thread(task);

		thread1.start();
		thread2.start();

		try {
			thread1.join();
			thread2.join();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Counter value now, " + counter);
	}

}

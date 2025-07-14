package multithreading.Assignments._4;

public class ClassLevelLock {

	private Integer counter = 0;
	
	public void increment() {
		synchronized (ClassLevelLock.class) {
			counter++;
		}
	}
	
	public void implementClassLevelLock() {

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

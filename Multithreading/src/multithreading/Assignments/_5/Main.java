package multithreading.Assignments._5;

public class Main {

	public static void main(String[] args) {

		// Implementing Reentrant Locks
		System.out.println("Implement Reentrant Lock");
		ReentrantLocks locks = new ReentrantLocks();
		Runnable task = () -> {
			for (int i = 0; i < 1000; i++) {
				locks.increment();
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
		System.out.println("Final count value - " + locks.getValue());
	}
}

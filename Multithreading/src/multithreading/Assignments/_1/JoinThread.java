package multithreading.Assignments._1;

public class JoinThread {

	//  Launch multiple threads and use join() to ensure they complete before main thread exits.
	
	public void runJoinExample() {

		Thread thread1 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
//					System.out.println("Thread " + Thread.currentThread().getName() + " - " + i);
				}
				System.out.println("T1 completed");
			}
		});

		Thread thread2 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
//					System.out.println("Thread " + Thread.currentThread().getName() + " - " + i);
				}
				System.out.println("T2 completed");
			}
		});

		thread1.start();
		thread2.start();

		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}

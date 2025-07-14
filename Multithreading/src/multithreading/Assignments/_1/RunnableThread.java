package multithreading.Assignments._1;

public class RunnableThread {
	
	//  Implement Runnable using both lambda and anonymous inner class.

	public void startThreads() {

		Thread lamdaThread = new Thread(() -> {
			for (int i = 1; i <= 10; i++) {
				System.out.println("Lambda Thread - " + i);
			}
		}, "Lambda Thread");

		Thread runnableThread = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 1; i <= 10; i++) {
					System.out.println("Anonymous Thread - " + i);
				}
			}
		});

		lamdaThread.start();
		runnableThread.start();
	}

}

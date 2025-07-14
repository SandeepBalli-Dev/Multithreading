package multithreading.Assignments._4;

public class RaceCondition {

	private int counter = 0;
	
	public void increment() {
		counter++;
	}
	
	public void implementRaceCondition() {
		Thread thread1 = new Thread(() -> {
			for(int i = 0; i < 1000; i++) {
				increment();
			}
		});
		
		Thread thread2 = new Thread(() -> {
			for(int i = 0; i < 1000; i++) {
				increment();
			}
		});
		
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

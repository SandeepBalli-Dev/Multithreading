package multithreading.Assignments._3;

public class PriorityThread {

	public void implementThreadPriority() {
		Runnable task = () -> {
			String name = Thread.currentThread().getName();
			for(int i = 0; i < 5; i++) {
				System.out.println("Thread: " + name + ", Priority: " + Thread.currentThread().getPriority());
            }
		};
		
		Thread lowPriority = new Thread(task, "Low Priority");
		Thread normPriority = new Thread(task, "Norm Priority");
		Thread highPriroty = new Thread(task, "High Priority");
		
		lowPriority.setPriority(Thread.MIN_PRIORITY);
		normPriority.setPriority(Thread.NORM_PRIORITY);
		highPriroty.setPriority(Thread.MAX_PRIORITY);
		
		lowPriority.start();
		normPriority.start();
		highPriroty.start();
	}
}

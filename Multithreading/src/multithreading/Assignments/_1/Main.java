package multithreading.Assignments._1;

public class Main {

	public static void main(String[] args) {
//		System.out.println("Implementing two threads example.");
//		TwoThreadsExample threadsExample = new TwoThreadsExample();
//		threadsExample.printNumbers();
		
//		System.out.println("Implementing runnable and lamda example");
//		RunnableThread runnableThread = new RunnableThread();
//		runnableThread.startThreads();
		
		System.out.println("Implementing join");
		JoinThread joinThread = new JoinThread();
		joinThread.runJoinExample();
		
		System.out.println("Hello from main class");
	}
}

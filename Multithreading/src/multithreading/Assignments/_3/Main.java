package multithreading.Assignments._3;

public class Main {

	public static void main(String[] args) {
		
//		System.out.println("Implmenting Daemon Thread");
//		DaemonThread daemonThread = new DaemonThread();
//		daemonThread.implementDaemonThread();
		
		System.out.println("Implementing Thread Priority");
		PriorityThread priorityThread = new PriorityThread();
		priorityThread.implementThreadPriority();
	}
}

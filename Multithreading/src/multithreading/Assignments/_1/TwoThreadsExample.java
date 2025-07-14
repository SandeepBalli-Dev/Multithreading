package multithreading.Assignments._1;

public class TwoThreadsExample {

//  Create a simple program with two threads printing numbers from 1 to 10.

	public void printNumbers() {
		Thread1 thread1 = new Thread1();
		Thread2 thread2 = new Thread2();

		thread1.start();
		thread2.start();
	}
}

class Thread1 extends Thread {

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.println("Thread 1, " + i);
		}
	}
}

class Thread2 extends Thread {

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.println("Thread 2, " + i);
		}
	}
}

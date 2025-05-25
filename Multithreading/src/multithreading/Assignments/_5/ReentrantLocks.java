package multithreading.Assignments._5;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLocks {

	private int count = 0;
	private final ReentrantLock lock = new ReentrantLock();

	public void increment() {
		lock.lock();
		try {
			count++;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	public int getValue() {
		return count;
	}

}

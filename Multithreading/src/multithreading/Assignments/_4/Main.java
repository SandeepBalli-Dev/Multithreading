package multithreading.Assignments._4;

public class Main {

	public static void main(String[] args) {

//		System.out.println("Implementing race condition.");
//		RaceCondition condition = new RaceCondition();
//		condition.implementRaceCondition();
		
//		System.out.println("Implementing race condition with synchronized method.");
//		RaceConditionSynchronized condition = new RaceConditionSynchronized();
//		condition.implementRaceConditionWithSynchronized();
		
//		System.out.println("Implementing a custom lock object");
//		CustomLockObject lockObject = new CustomLockObject();
//		lockObject.implementCustomLockObject();
		
		System.out.println("Implementing a Class level lock");
		ClassLevelLock lock = new ClassLevelLock();
		lock.implementClassLevelLock();
	}
}

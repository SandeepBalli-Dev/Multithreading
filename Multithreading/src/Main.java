import com.banking.BankAccount;
import com.banking.User;
import com.threading.MyRunnable;
import com.threading.ThreadClass;

public class Main {

	public static void main(String[] args) {

//		ThreadClass thread1 = new ThreadClass();
//		thread1.start();
//
//		MyRunnable runnableThread = new MyRunnable();
//		Thread thread2 = new Thread(runnableThread);
//		thread2.start();
//
//		Thread lambdaThread = new Thread(() -> {
//			System.out.println("Lambda thread is running..");
//		});
//
//		lambdaThread.start();

		BankAccount bankAccount = new BankAccount(1000.0);

		User sandeep = new User(bankAccount, "Sandeep", 600.0);
		User gourang = new User(bankAccount, "Gourang", 500.0);
		User sashy = new User(bankAccount, "Sashy", 400.0);

		Thread t1 = new Thread(gourang);
		Thread t2 = new Thread(sashy);
		Thread t3 = new Thread(sandeep);

		t1.start();
		t2.start();
		t3.start();

	}
}

package multithreading.Assignments._6;

public class PingPong {

	private boolean isPingTurn = true;

	public synchronized void sayPing() throws InterruptedException {
		while (!isPingTurn) {
			wait();
		}

		System.out.println("PING");
		isPingTurn = false;
		notify();
	}

	public synchronized void sayPong() throws InterruptedException {
		while (isPingTurn) {
			wait();
		}

		System.out.println("PONG");
		isPingTurn = true;
		notify();
	}

	public void implementPingPong() throws InterruptedException {
		Thread pingThread = new Thread(() -> {
			for (int i = 1; i <= 5; i++) {
				try {
					sayPing();
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			}
		});

		Thread pongThread = new Thread(() -> {
			for (int i = 1; i <= 5; i++) {
				try {
					sayPong();
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			}
		});

		pingThread.start();
		pongThread.start();
	}

}

package com.threading;

public class ThreadClass extends Thread {

	@Override
	public void run() {

		for (int i = 1; i <= 10; i++) {
			System.out.println("Downloading " + i + "%");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

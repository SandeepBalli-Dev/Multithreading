package com.banking;

public class BankAccount {

	private Double balance;

	public BankAccount(Double balance) {
		super();
		this.balance = balance;
	}

	public synchronized void withdraw(String name, Double amount) {
		System.out.println(name + " is attempting to withdraw ₹" + amount);

		if (balance >= amount) {
			System.out.println(name + " is allowed to withdraw ₹" + amount);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			balance -= amount;
			System.out.println(name + " successfully withdrew ₹" + amount);
		} else {
			System.out.println("Insufficient balance for " + name);
		}

		System.out.println("Remaining balance: ₹" + balance + "\n");
	}
}

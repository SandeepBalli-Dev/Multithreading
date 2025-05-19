package com.banking;

public class User implements Runnable {

	private BankAccount bankAccount;
	private String name;
	private double amount;

	public BankAccount getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public User(BankAccount bankAccount, String name, double amount) {
		super();
		this.bankAccount = bankAccount;
		this.name = name;
		this.amount = amount;
	}

	@Override
	public void run() {
		bankAccount.withdraw(name, amount);

	}

}

package com.learnings;

public class WaitNotifyNotifyAllLearningWithoutSyncMethods {

	public static void main(String[] args) {
		Customer1243 c1 = new Customer1243();

		new Thread() {
			public void run() {
				c1.withdraw(1000000000);
			}
		}.start();

		new Thread() {
			public void run() {
				c1.deposit(1000000);
				;
			}
		}.start();
	}

}

class Customer1243 {
	int amount = 10000;

	// we remove sync word and it works like the earlier code.
	// this is because this is small program
	// there can be possibility of mix and match for larger programs.
	void withdraw(int amount) {
		if (this.amount < amount) {
			System.out.println("less balance , wait for deposit to happen");
			try {
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		this.amount = this.amount - amount;
		System.out.println("withdraw completed");

	}

	// we remove sync word and it works like the earlier code.
	// this is because this is small program
	// there can be possibility of mix and match for larger programs.
	void deposit(int amount) {
		this.amount = this.amount + amount;
		System.out.println("deposit success");
	}
}
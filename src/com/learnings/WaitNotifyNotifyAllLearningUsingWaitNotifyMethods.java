package com.learnings;

public class WaitNotifyNotifyAllLearningUsingWaitNotifyMethods {

	// when we add wait(), notify(), notifyall() the program runs smoothly.
	// so first we try to withdraw money.
	// balance is low.
	// we make this thread wait() for the balance to be increased.
	// then we run the deposit method.
	// once deposit done, then we use notify() method to inform the waiting thread
	// to start running again
	// see the output, first balance low, then deposit, then withdraw

	public static void main(String[] args) {
		Customer1245 c1 = new Customer1245();

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

class Customer1245 {
	int amount = 10000;

	synchronized void withdraw(int amount) {
		if (this.amount < amount) {
			System.out.println("less balance , wait for deposit to happen");
			try {
				// add wait() method for this process to stop if the balance is less in bank.
				wait();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		this.amount = this.amount - amount;
		System.out.println("withdraw completed");

	}

	synchronized void deposit(int amount) {
		this.amount = this.amount + amount;
		System.out.println("deposit success");
		// add notify() method for this process to run and then inform the waiting
		// process stating deposit is completed.
		notify();
	}
}
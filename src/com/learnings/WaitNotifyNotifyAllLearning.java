package com.learnings;

public class WaitNotifyNotifyAllLearning {

	// Wait – wait for one thread to complete work before starting its work.
	// Notify- tells the other threads that my work is over and you all can get back
	// to resume work. Notify() tracks only one thread.
	// Notifyall – tells the other threads that my work is over and you can get back
	// to resume work. NotifyAll() tracks all threads.

	// when we work with same object across different functions (customer object)
	// and there is
	// dependency between them (deposit amount and then withdraw amount), in such
	// cases we try to avoid deadlocks.

	// Wait notify notifyall-
	// To resolve deadlocks.

	// note the output without the wait() and notify() methods.
	// its mix and match between withdraw and deposit.

	public static void main(String[] args) {
		Customer c1 = new Customer();
		// anonymous class
		// see how to add all in one line upto thread.start()
		// for withdraw
		new Thread() {
			public void run() {
				c1.withdraw(1000000000);
			}
		}.start();

		// anonymous class
		// see how to add all in one line upto thread.start()
		// for deposit
		new Thread() {
			public void run() {
				c1.deposit(1000000);
				;
			}
		}.start();
	}

}

//create customer class.
//we need to ensure customer can only withdraw amount equal to or less than the amount in his or 
//her bank account.
//deposit bigger amount and then you can withdraw the amount equal to or less than the total balance.
class Customer {
	int amount = 10000;

	// lets make method synchronised to avoid discrepancies
	synchronized void withdraw(int amount) {
		if (this.amount < amount) {
			System.out.println("less balance , wait for deposit to happen");
			try {
//				 wait();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		this.amount = this.amount - amount;
		System.out.println("withdraw completed");

	}

	// deposit method
	// lets make method synchronised to avoid discrepancies
	synchronized void deposit(int amount) {
		this.amount = this.amount + amount;
		System.out.println("deposit success");
//		notify();
	}
}
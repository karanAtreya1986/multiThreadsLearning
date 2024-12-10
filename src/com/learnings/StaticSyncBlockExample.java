package com.learnings;

public class StaticSyncBlockExample {

	// Static synchronization-
	// This keyword cant be used here. Static belongs to class. This belongs to
	// object. No constructor needed as static is all about class. Constructors
	// needed to initialize objects only.
	// Call method using class name. static synchronized applies lock at class level
	// because static belongs to class.
	// Run code – every thread locks the sync method works and then releases.
	// Note – execution need not be in same order as we write thread.start().

	// this keyword is for objects.
	// Class name has to be used for static.

	// static sync block is below.

	// lock is on class level, because to access static sync method we need class
	// name.

	synchronized static void print(int n) {
		for (int i = 0; i < 5; i++) {
			System.out.println(n * i);
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// output will be one thread first completing , then second thread and so on
	// no mix and match
	public static void main(String[] args) {

		// no need to create object of class as we are dealing with static

		Thread21 thread21 = new Thread21();
		Thread22 thread22 = new Thread22();
		Thread23 thread23 = new Thread23();
		Thread24 thread24 = new Thread24();

		thread21.start();
		thread22.start();
		thread23.start();
		thread24.start();
	}
}

//lets create four classes
//to access static method use class name.

class Thread21 extends Thread {
	public void run() {
		StaticSyncBlockExample.print(1);
	}
}

class Thread22 extends Thread {
	public void run() {
		StaticSyncBlockExample.print(2);
	}
}

class Thread23 extends Thread {
	public void run() {
		StaticSyncBlockExample.print(3);
	}
}

class Thread24 extends Thread {
	public void run() {
		StaticSyncBlockExample.print(4);
	}
}

package com.learnings;

public class DeadlockExample {

	// Deadlock-
	// One thread waiting for lock taken by second thread. And second thread is in
	// turn waiting for lock taken by the first thread.
	// Deadlocks happen only in multithreading.

	public static void main(String[] args) {
		String resource1 = "A";
		String resource2 = "B";

		// threads created to access the resources.
		// use anonymous class implementation.

		// deadlock has come
		// multiple resources trying to be accessed by both threads

		Thread t1 = new Thread() {
			public void run() {

				// first tried to access resource1

				// how to use sync on variable name.
				synchronized (resource1) {
					System.out.println("thread 1 is using the lock - resource 1");

					try {
						Thread.sleep(100);
					} catch (Exception e) {
						e.printStackTrace();
					}
					// thread1 trying to access resource 2 also
					synchronized (resource2) {
						System.out.println("thread 1 is using the lock - resource 2");
					}
				}
			}
		};

		// lets create another thread
		Thread t2 = new Thread() {
			public void run() {
				// trying to access resource2
				synchronized (resource2) {
					System.out.println("thread 2 is using the lock - resource 2");

					try {
						Thread.sleep(100);
					} catch (Exception e) {
						e.printStackTrace();
					}
					// thread2 trying to access resource 1 also
					synchronized (resource1) {
						System.out.println("thread 2 is using the lock - resource 1");
					}
				}
			}
		};

		t1.start();
		t2.start();
	}

}

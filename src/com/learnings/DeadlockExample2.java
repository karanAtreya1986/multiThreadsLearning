package com.learnings;

public class DeadlockExample2 {

	public static void main(String[] args) {
		String resource1 = "A";
		String resource2 = "B";

		// placement of sync block matters for deadlock to come
		// else program runs smoothly

		Thread t1 = new Thread() {
			public void run() {

				// thread1 uses resource1
				// once the sync block done, then thread1 tries to access resource2
				// so no issues
				synchronized (resource1) {
					System.out.println("thread 1 is using the lock - resource 1");

					try {
						Thread.sleep(100);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				synchronized (resource2) {
					System.out.println("thread 1 is using the lock - resource 2");
				}

			}
		};

		// thread2 uses resource2
		// once the sync block done, then thread2 tries to access resource1
		// so no issues
		Thread t2 = new Thread() {
			public void run() {
				synchronized (resource2) {
					System.out.println("thread 2 is using the lock - resource 2");

					try {
						Thread.sleep(100);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				// thread2 trying to access resource 1 also
				synchronized (resource1) {
					System.out.println("thread 2 is using the lock - resource 1");
				}

			}
		};

		t1.start();
		t2.start();
	}

}

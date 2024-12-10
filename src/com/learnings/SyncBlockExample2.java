package com.learnings;

public class SyncBlockExample2 {

	// Perform synchronization on any lines inside method. - sync block.

	// in our case output is not consistent here
	// we added sync block for the sleep statement inside try block.

	void print(int n) {

		for (int i = 0; i < 5; i++) {

			System.out.println(n * i);

			try {
				synchronized (this) {
					Thread.sleep(100);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {

		SyncBlockExample2 o1 = new SyncBlockExample2();
		Thread7 t1 = new Thread7(o1);
		Thread8 t2 = new Thread8(o1);

		t1.start();
		t2.start();
	}
}

class Thread8 extends Thread {

	SyncBlockExample2 object1;

	Thread8(SyncBlockExample2 object1) {
		this.object1 = object1;
	}

	public void run() {
		object1.print(5);
	}
}

class Thread7 extends Thread {
	SyncBlockExample2 object2;

	Thread7(SyncBlockExample2 object2) {
		this.object2 = object2;
	}

	public void run() {
		object2.print(100);
	}

}

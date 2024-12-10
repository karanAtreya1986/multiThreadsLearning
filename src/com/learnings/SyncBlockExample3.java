package com.learnings;

public class SyncBlockExample3 {

	// Perform synchronization on any lines inside method. - sync block.

	// in our case output is consistent here because we added sync for the entire
	// loop

	void print(int n) {
		synchronized (this) {
			for (int i = 0; i < 5; i++) {

				System.out.println(n * i);

				try {

					Thread.sleep(100);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {

		SyncBlockExample3 o1 = new SyncBlockExample3();
		Thread9 t1 = new Thread9(o1);
		Thread10 t2 = new Thread10(o1);

		t1.start();
		t2.start();
	}
}

class Thread9 extends Thread {

	SyncBlockExample3 object1;

	Thread9(SyncBlockExample3 object1) {
		this.object1 = object1;
	}

	public void run() {
		object1.print(5);
	}
}

class Thread10 extends Thread {
	SyncBlockExample3 object2;

	Thread10(SyncBlockExample3 object2) {
		this.object2 = object2;
	}

	public void run() {
		object2.print(100);
	}

}

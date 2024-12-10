package com.learnings;

public class SyncBlockExample {

	// Perform synchronization on any lines inside method. - sync block.

	// in our case output is consistent here as we added sync block for the loop

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

		SyncBlockExample o1 = new SyncBlockExample();
		Thread5 t1 = new Thread5(o1);
		Thread6 t2 = new Thread6(o1);

		t1.start();
		t2.start();
	}
}

class Thread5 extends Thread {

	SyncBlockExample object1;

	Thread5(SyncBlockExample object1) {
		this.object1 = object1;
	}

	public void run() {
		object1.print(5);
	}
}

class Thread6 extends Thread {
	SyncBlockExample object2;

	Thread6(SyncBlockExample object2) {
		this.object2 = object2;
	}

	public void run() {
		object2.print(100);
	}

}

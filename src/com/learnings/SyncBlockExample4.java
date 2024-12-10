package com.learnings;

public class SyncBlockExample4 {

	// Perform synchronization on any lines inside method. - sync block.

	// in our case output is not consistent here, we added sync block just for the
	// print statement.

	void print(int n) {

		for (int i = 0; i < 5; i++) {
			synchronized (this) {
				System.out.println(n * i);
			}
			try {

				Thread.sleep(100);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {

		SyncBlockExample4 o1 = new SyncBlockExample4();
		Thread11 t1 = new Thread11(o1);
		Thread12 t2 = new Thread12(o1);

		t1.start();
		t2.start();
	}
}

class Thread11 extends Thread {

	SyncBlockExample4 object1;

	Thread11(SyncBlockExample4 object1) {
		this.object1 = object1;
	}

	public void run() {
		object1.print(5);
	}
}

class Thread12 extends Thread {
	SyncBlockExample4 object2;

	Thread12(SyncBlockExample4 o1) {
		this.object2 = o1;
	}

	public void run() {
		object2.print(100);
	}

}

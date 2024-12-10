package com.learnings;

public class UseSyncMethodToRunOneThreadAtATime {

	// make the common method sync
	// now there will be no mix match in result
	// at a time one thread runs and then second thread

	// First lock the resource – use it – then release it.

	synchronized void print(int n) {
		for (int i = 0; i < 5; i++) {
			System.out.println(n * i);
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {

		UseSyncMethodToRunOneThreadAtATime o1 = new UseSyncMethodToRunOneThreadAtATime();
		Thread3 t1 = new Thread3(o1);
		Thread4 t2 = new Thread4(o1);

		t1.start();
		t2.start();
	}
}

class Thread3 extends Thread {

	UseSyncMethodToRunOneThreadAtATime object1;

	Thread3(UseSyncMethodToRunOneThreadAtATime object1) {
		this.object1 = object1;
	}

	public void run() {
		object1.print(5);
	}
}

class Thread4 extends Thread {

	UseSyncMethodToRunOneThreadAtATime object2;

	Thread4(UseSyncMethodToRunOneThreadAtATime object2) {
		this.object2 = object2;
	}

	public void run() {
		object2.print(100);
	}
}

package com.learnings;

public class SynchronisationExample {

	// One thread to access shared resource. Sync used to prevent thread
	// interference and giving abrupt results.
	
	//we are using non sync methods
	//we will see how mix and match comes in output due to no sync

	// non sync method
	void print(int n) {
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
		
		//create object of main class and thread class
		SynchronisationExample o1 = new SynchronisationExample();
		Thread1 t1 = new Thread1(o1);
		Thread2 t2 = new Thread2(o1);

		t1.start();
		t2.start();
	}
}

//one class extending thread
class Thread1 extends Thread {
	// create object of upper class
	SynchronisationExample object1;

	// create constructor
	Thread1(SynchronisationExample object1) {
		this.object1 = object1;
	}

	public void run() {
		object1.print(5);
	}
}

//second class extending thread
class Thread2 extends Thread {
	// create object of upper class
	SynchronisationExample object2;

	// create constructor
	Thread2(SynchronisationExample object2) {
		this.object2 = object2;
	}

	public void run() {
		object2.print(100);
	}
}

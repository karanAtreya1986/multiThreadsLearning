package com.learnings;

public class RentrantThreadOrRetrantMonitorMeaning {
	
	public static void main(String[] args) {
		ClassWithTwoSyncTasks o1=new ClassWithTwoSyncTasks();
		
		//anonymous class implementation.
		//one thread can call different sync methods.
		Thread t1=new Thread() {
			public void run() {
				o1.m();
			}
		};
		t1.start();
	}
}

	class ClassWithTwoSyncTasks{
		synchronized void m() {
			n();
			System.out.println("synchronised m method");
		}
		
		synchronized void n() {
			System.out.println("synchronised n method");
		}
	}
	


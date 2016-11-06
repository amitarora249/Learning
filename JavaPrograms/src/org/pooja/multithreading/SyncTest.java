package org.pooja.multithreading;

public class SyncTest {

	public int status = 1;
	public static void main(String[] args) {
		
		SyncTest syncTest = new SyncTest();
		
		Thread t1 = new Thread(new T1(syncTest));
		Thread t2 = new Thread(new T2(syncTest));
		Thread t3 = new Thread(new T3(syncTest));
		
		t1.start();
		t2.start();
		t3.start();
	}
}

class T1 implements Runnable{

	private SyncTest syncTest;
	
	public T1(SyncTest syncTest) {
		this.syncTest = syncTest;
	}

	@Override
	public void run() {
		while(true){
			synchronized (syncTest) {
				while(syncTest.status != 1){
					try {
						syncTest.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				print1();
				syncTest.status = 2;
				syncTest.notifyAll();
			}
		}
	}

	private void print1() {
		System.out.println("1");
	}
}

class T2 implements Runnable{

	private SyncTest syncTest;
	
	public T2(SyncTest syncTest) {
		this.syncTest = syncTest;
	}

	@Override
	public void run() {
		while(true){
			synchronized (syncTest) {
				while(syncTest.status != 2){
					try {
						syncTest.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				print2();
				syncTest.status = 3;
				syncTest.notifyAll();
			}
		}
	}

	private void print2() {
		System.out.println("2");
	}
}

class T3 implements Runnable{

	private SyncTest syncTest;
	
	public T3(SyncTest syncTest) {
		this.syncTest = syncTest;
	}

	@Override
	public void run() {
		while(true){
			synchronized (syncTest) {
				while(syncTest.status != 3){
					try {
						syncTest.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				print3();
				syncTest.status = 1;
				syncTest.notifyAll();
			}
		}
	}

	private void print3() {
		System.out.println("3");
	}
}

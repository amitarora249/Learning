package org.pooja.concurrency.locks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {

	private Lock listLock = new ReentrantLock();
	private Condition MAX_SIZE = listLock.newCondition();
	private Condition MIN_SIZE = listLock.newCondition();
	private List<Integer> sharedList = new ArrayList<>();

	private final int MAX_ELEMS = 10;

	public void produce(double random) {
		listLock.lock();
		try {
			if (sharedList.size() == MAX_ELEMS) {
				try {
					MAX_SIZE.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				sharedList.add((int) random);
				MIN_SIZE.signalAll();
			}
		} finally {
			listLock.unlock();
		}

	}

	public int consume() {
		listLock.lock();
		try {
			int consumerData = 0;
			if (sharedList.size() == 0) {
				try {
					MIN_SIZE.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				Random r = new Random();
				int low = 0;
				int high = 9;
				int result = r.nextInt(high - low) + low;
				consumerData = sharedList.get(result);
				MAX_SIZE.signalAll();
			}
			return consumerData;
		} finally {
			listLock.unlock();
		}

	}
}

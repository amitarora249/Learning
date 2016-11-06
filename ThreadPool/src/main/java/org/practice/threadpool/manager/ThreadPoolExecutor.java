package org.practice.threadpool.manager;

import org.practice.blocking.queue.CustomBlockingQueue;
import org.practice.blocking.queue.CustomQueue;

public class ThreadPoolExecutor<E> {

	private int maxThreadCount;
	private CustomQueue<Runnable> customBlockingQueue;
	
	public ThreadPoolExecutor(int maxThreadCount) {
		this.maxThreadCount = maxThreadCount;
		customBlockingQueue = new CustomBlockingQueue<Runnable>(maxThreadCount);
		initializeWorkerThreads(maxThreadCount);
	}
	
	private void initializeWorkerThreads(int maxThreadCount2) {
		int i = 1;
		while(i<=maxThreadCount){
			new Thread(new WorkerThread(customBlockingQueue)).start();
		}
	}

	public void executeTask(Runnable task){
		customBlockingQueue.enQueue(task);
	}
	
}

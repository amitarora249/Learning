package org.practice.threadpool.manager;

import org.practice.blocking.queue.CustomQueue;

public class WorkerThread implements Runnable {
	private CustomQueue<Runnable> taskQueue;

	public WorkerThread(CustomQueue<Runnable> customBlockingQueue) {
	}

	public void run(){
		while(true){
			Runnable task = taskQueue.deQueue();
			task.run();
		}
	}
}

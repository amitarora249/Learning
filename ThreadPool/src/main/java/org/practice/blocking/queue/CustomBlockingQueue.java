package org.practice.blocking.queue;

import java.lang.reflect.Array;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CustomBlockingQueue<E> implements CustomQueue<E> {

	private E[] array;
	private int front;
	private int rear;
	private int size;
	private int capacity;
	private Lock lock;
	private final Condition QUEUE_FULL;
	private final Condition QUEUE_EMPTY;
	
	@SuppressWarnings("unchecked")
	public CustomBlockingQueue(int capacity){
		this.array 			= (E[])Array.newInstance(this.getClass(), capacity);
		this.front 			= -1;
		this.rear  			= -1;
		this.size  			= array.length;
		this.capacity 		= capacity;
		this.lock 			= new ReentrantLock();
		this.QUEUE_FULL 	= lock.newCondition();
		this.QUEUE_EMPTY 	= lock.newCondition();
	}
	
	public void enQueue(E data) {
		try{
			lock.tryLock();
			if(isFull()){
				try {
					QUEUE_FULL.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}else{
				rear = (rear+1)%capacity;
				array[rear] = data;
				
				if(front == -1)
					front = rear;
				QUEUE_FULL.signalAll();
			}
			size = array.length;
		}finally{
			lock.unlock();
		}
		
	}

	private boolean isFull() {
		return (array.length == capacity);
	}

	public E deQueue() {
		E data = null;
		try {
			lock.tryLock();
			if(isEmpty()){
				try {
					QUEUE_EMPTY.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}else{
				data = array[front];
				if(front == rear)
					front = rear = -1;
				front = (front+1)%capacity;
				QUEUE_EMPTY.signalAll();
			}
			size = array.length;
		} finally {
			lock.unlock();
		}
		return data;
	}

	private boolean isEmpty() {
		return (array.length == 0);
	}

	public int size(){
		return size;
	}
}

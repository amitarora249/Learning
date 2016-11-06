package org.pooja.demo.locks;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerImpl {
	private List<String> names = new ArrayList<>();
	private static final int CAPACITY = 10;
	private Lock producerConsLock = new ReentrantLock();
	private final Condition BUFFER_FULL = producerConsLock.newCondition();
	private final Condition BUFFER_EMPTY = producerConsLock.newCondition();
	
	
	public void produceData(String name){
		System.out.println("Trying to add name: "+name+" in the list");
		try{
			producerConsLock.lock();
			if(names.size() == CAPACITY){
				System.out.println("Waiting for buffer to be empty");
				try {
					BUFFER_FULL.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}else{
				boolean isAdded = names.add(name);
				if(isAdded){
					System.out.println("Name: "+name+"  added in the list, Notifying the consumer threads. Thread ==> "
								+ Thread.currentThread().getName());
					BUFFER_EMPTY.signalAll();
				}else{
					System.out.println("Could not add name : "+name +" in the list.");
				}
			}
			
		}finally{
			producerConsLock.unlock();
		}
		
	}
	
	public void consumeData(){
		System.out.println("Trying to remove name in the list.");
		try {
			producerConsLock.lock();
			if (names.isEmpty()) {
				System.out.println("Waiting for buffer to be filled");
				try {
					BUFFER_EMPTY.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				String name = names.remove(0);
				System.out.println("Name: " + name+"  removed from the list successfully. Thread ==> "+
								Thread.currentThread().getName());
				BUFFER_FULL.signalAll();
			}
		} finally {
			producerConsLock.unlock();
		}
	}
}

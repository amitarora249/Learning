package org.pooja.concurrency.locks;

class Prodcuer implements Runnable {

	private SharedResource sharedResource = null;
	
	public Prodcuer(SharedResource resource){
		sharedResource = resource;
	}
	
	@Override
	public void run() {
		double random = Math.random()*10*5;
		System.out.println("Data ==> "+random);
		sharedResource.produce(random);
	}
}

class Consumer implements Runnable {

	private SharedResource sharedResource = null;
	
	public Consumer(SharedResource resource){
		sharedResource = resource;
	}
	
	@Override
	public void run() {
		int consumeData = sharedResource.consume();
		System.out.println("consumeData ==> "+consumeData);
	}
}

class ProducerConsumerTest {

	public static void main(String[] args) {
		SharedResource sharedResource = new SharedResource();
		for(int i = 0; i<=10; i++){
			Prodcuer prodcuer = new Prodcuer(sharedResource);
			new Thread(prodcuer).start();
		}
		
		for(int i = 0; i<=10; i++){
			Consumer consumer = new Consumer(sharedResource);
			new Thread(consumer).start();
		}
	}

}
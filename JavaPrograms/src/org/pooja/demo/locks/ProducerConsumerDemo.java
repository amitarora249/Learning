package org.pooja.demo.locks;




class Producer implements Runnable {
	
	private ProducerConsumerImpl  prodConImpl = null;
	private String name = null;
	public Producer(String name, ProducerConsumerImpl sharedObj){
		this.name = name;
		this.prodConImpl = sharedObj;
	}

	@Override
	public void run() {
		prodConImpl.produceData(name);
	}

}

class Consumer implements Runnable{
	private ProducerConsumerImpl  prodConImpl = null;
	public Consumer(ProducerConsumerImpl sharedObj){
		this.prodConImpl = sharedObj;
	}
	

	@Override
	public void run() {
		prodConImpl.consumeData();
	}
	
}

public class ProducerConsumerDemo{
	private static ProducerConsumerImpl sharedObj = new ProducerConsumerImpl();
	
	public static void main(String[] args) {
		new ProducerConsumerDemo().createThreads();
	}
	
	public void createThreads(){
		for(int i=0;i<=15;i++){
			Thread thread = new Thread(new Producer("name ==> "+i, sharedObj), "name: "+i);
			thread.start();
		}
		
		for(int i=0;i<=18;i++){
			Thread thread = new Thread(new Consumer(sharedObj), "name: "+i);
			thread.start();
		}
	}
	
}
package org.pooja.concurrency.executors;

import java.util.Date;
import java.util.Timer;

public class TimerExample {
	public static void main(String[] args) {
		Timer timer = new Timer();

		Task task1 = new Task("Demo Task 1");
		Task task2 = new Task("Demo Task 2");

		System.out.println("The time is : " + new Date());

		timer.schedule(task1, 5000, 10000);
		
		timer.schedule(task2, 15000, 20000);
		
	}
}

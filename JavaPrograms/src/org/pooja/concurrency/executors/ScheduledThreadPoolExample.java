package org.pooja.concurrency.executors;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
 
public class ScheduledThreadPoolExample
{
    public static void main(String[] args) 
    {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
        Task task1 = new Task ("Demo Task 1");
        Task task2 = new Task ("Demo Task 2");
         
        System.out.println("The time is : " + new Date());
         
        executor.scheduleWithFixedDelay(task1, 5 ,10, TimeUnit.SECONDS);
        try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        executor.scheduleWithFixedDelay(task2, 10 ,20, TimeUnit.SECONDS);
         
        try {
              executor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
              e.printStackTrace();
        }
         
        executor.shutdown();
    }
}
package org.pooja.concurrency.executors;

import java.util.Date;
import java.util.TimerTask;


class Task extends TimerTask
{
    private String name;
 
    public Task(String name) {
        this.name = name;
    }
     
    public String getName() {
        return name;
    }
 
    @Override
    public void run() 
    {
        try {
            System.out.println("Doing a task during : " + name + " - Time - " + new Date());
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

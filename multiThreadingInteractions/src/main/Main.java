package main;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import runnableClasses.CounterClass_NEW;
import sharedData.CounterList_NEW;

public class Main {

	public static void main(String[] args) {
		
		ExecutorService threadPool = Executors.newFixedThreadPool(5);
		
		CounterList_NEW communication = new CounterList_NEW();
		
		Runnable thread1 = new CounterClass_NEW("Thread 1", 5, 3000, communication);
        Runnable thread2 = new CounterClass_NEW("Thread 2", 5, 6000, communication);
        Runnable thread3 = new CounterClass_NEW("Thread 3", 5, 9000, communication);
		
        threadPool.execute(thread1);
        threadPool.execute(thread2);
        threadPool.execute(thread3);
        
	}

}

package main;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import logger.Logger;
import threadPool.ServiceExecutor;

public class Main {
	
	static final int maximumThreads = 2; 
	
	public static void main(String[] args) {
		
		Logger logger = Logger.getInstance();
		
		ExecutorService threadPool = Executors.newFixedThreadPool(maximumThreads);
		
		Runnable task1 = new ServiceExecutor("task 1", 1);
        Runnable task2 = new ServiceExecutor("task 2", 2);
        Runnable task3 = new ServiceExecutor("task 3", 3);
        
        logger.info(Main.class.getName(), new Exception(), "Start execution of tasks");
        
        threadPool.execute(task1);
        threadPool.execute(task2);
        threadPool.execute(task3);
        
        try {
        	logger.info(Main.class.getName(), new Exception(), "Wait");
			Thread.sleep(6000);
		} catch (InterruptedException interruptedException) {
			logger.info(Main.class.getName(), interruptedException, interruptedException.getMessage());
		}
        
        
        logger.info(Main.class.getName(), new Exception(), "Shutdown pool");
        threadPool.shutdown();
		
		
	}

}
